package by.yarik.cats_impl.mapper

import by.yarik.cats_impl.model.CatsModel
import by.yarik.core.db.entity.FavoriteCatDb
import by.yarik.core.network.pojo.CatsResponse
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.Function

object CatsModelMapper {

    fun mapCatsModelItems(responses: List<CatsResponse>) :Single<List<CatsModel>> {
        return Observable.fromIterable(responses)
            .map(mappingCatsResponseIntem())
            .toList()
    }

    private fun mappingCatsResponseIntem(): Function<CatsResponse, CatsModel> {
        return Function {
            return@Function CatsModel(it.url, it.id)
        }
    }

    fun mapCatsModelItemsFromDb(entities: List<FavoriteCatDb>) :Single<List<CatsModel>> {
        return Observable.fromIterable(entities)
            .map(mappingCatsEntityIntem())
            .toList()
    }

    private fun mappingCatsEntityIntem(): Function<FavoriteCatDb, CatsModel> {
        return Function {
            return@Function CatsModel(it.url, "")
        }
    }
}