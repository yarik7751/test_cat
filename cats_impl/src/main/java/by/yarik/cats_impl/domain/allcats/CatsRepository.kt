package by.yarik.cats_impl.domain.allcats

import by.yarik.cats_impl.model.CatsModel
import by.yarik.core.domain.BaseRepository
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.ResponseBody

interface CatsRepository : BaseRepository {

    fun getAllCats(limit : Int) : Single<List<CatsModel>>

    fun downloadCatImage(url: String): Single<ResponseBody>

    fun addCatToFavorite(url: String): Completable

    fun getFavoriteCats(): Single<List<CatsModel>>
}