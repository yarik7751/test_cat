package by.yarik.cats_impl.data.allcats

import by.yarik.cats_impl.domain.allcats.CatsRepository
import by.yarik.cats_impl.mapper.CatsModelMapper
import by.yarik.cats_impl.model.CatsModel
import by.yarik.core.data.BaseRepositoryImpl
import by.yarik.core.db.FavoriteCatsDatabase
import by.yarik.core.db.entity.FavoriteCatDb
import by.yarik.core.network.Api
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.ResponseBody

class CatsRepositoryImpl(var api: Api, var database: FavoriteCatsDatabase) : BaseRepositoryImpl(),
    CatsRepository {

    override fun getAllCats(limit : Int) : Single<List<CatsModel>> {
        val data = HashMap<String, Any>()
        data.put("limit", limit)

        return api.getListOfCats(data).flatMap {
            CatsModelMapper.mapCatsModelItems(it)
        }
    }

    override fun downloadCatImage(url: String): Single<ResponseBody> {
        return api.downloadFileWithUrl(url)
    }

    override fun addCatToFavorite(url: String): Completable {
        return Completable.fromCallable {
            val favoriteCat = FavoriteCatDb(0, url)
            database.getFavoriteCatsDao().addFavoriteCat(favoriteCat)
            return@fromCallable Completable.complete()
        }
    }

    override fun getFavoriteCats(): Single<List<CatsModel>> {
        return Single.fromCallable {
            return@fromCallable database.getFavoriteCatsDao().getAllFavoriteCats()
        }.flatMap {
            return@flatMap CatsModelMapper.mapCatsModelItemsFromDb(it)
        }
    }
}