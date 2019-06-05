package by.yarik.cats_impl.data.favoritecats

import by.yarik.cats_impl.domain.favoritecats.FavoriteCatsRepository
import by.yarik.cats_impl.mapper.CatsModelMapper
import by.yarik.cats_impl.model.CatsModel
import by.yarik.core.data.BaseRepositoryImpl
import by.yarik.core.db.FavoriteCatsDatabase
import io.reactivex.Single

class FavoriteCatsRepositoryImpl(var database: FavoriteCatsDatabase): BaseRepositoryImpl(), FavoriteCatsRepository {

    override fun getFavoriteCats(): Single<List<CatsModel>> {
        return Single.fromCallable {
            return@fromCallable database.getFavoriteCatsDao().getAllFavoriteCats()
        }.flatMap {
            return@flatMap CatsModelMapper.mapCatsModelItemsFromDb(it)
        }
    }
}