package by.yarik.cats_impl.domain.allcats

import android.os.Environment
import by.yarik.cats_impl.mapper.CatsViewModelMapper
import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.domain.BaseInteractorImpl
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import java.io.*
import java.io.File.separator


class CatsInteractorImpl(var repository: CatsRepository) : BaseInteractorImpl(),
    CatsInteractor {

    override fun getCats(limit : Int) : Single<List<CatsViewModel>> {
        return repository.getAllCats(limit)
            .flatMap { CatsViewModelMapper.mapCatsViewModelItems(it) }
            .subscribeOn(Schedulers.io())
    }

    override fun getFavoriteCats(): Single<List<CatsViewModel>> {
        return repository.getFavoriteCats()
            .flatMap {
                return@flatMap CatsViewModelMapper.mapCatsViewModelItems(it)
            }
            .subscribeOn(Schedulers.io())
    }

    override fun downloadCatImage(url: String): Single<Boolean> {
        return repository.downloadCatImage(url)
            .map {
                return@map writeResponseBodyToDisk(it)
            }
            .subscribeOn(Schedulers.io())
    }

    override fun addCatToFavorite(url: String): Completable {
        return repository.addCatToFavorite(url)
            .subscribeOn(Schedulers.io())
    }

    private fun writeResponseBodyToDisk(body: ResponseBody): Boolean {
        try {
            val timeStamp = System.currentTimeMillis()
            val downloadFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath
            val futureFile = File(downloadFolder + separator + timeStamp + ".png")
            if (!futureFile.exists()) {
                futureFile.createNewFile()
            }

            var inputStream: InputStream? = null
            var outputStream: OutputStream? = null

            try {
                val fileReader = ByteArray(4096)

                val fileSize = body.contentLength()
                var fileSizeDownloaded: Long = 0

                inputStream = body.byteStream()
                outputStream = FileOutputStream(futureFile)

                while (true) {
                    val read = inputStream!!.read(fileReader)

                    if (read == -1) {
                        break
                    }

                    outputStream!!.write(fileReader, 0, read)

                    fileSizeDownloaded += read.toLong()
                }

                outputStream!!.flush()

                return true
            } catch (e: IOException) {
                return false
            } finally {
                if (inputStream != null) {
                    inputStream!!.close()
                }

                if (outputStream != null) {
                    outputStream!!.close()
                }
            }
        } catch (e: IOException) {
            return false
        }

    }
}