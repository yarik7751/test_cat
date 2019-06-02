package by.yarik.cats_impl.data

import by.yarik.cats_impl.domain.CatsRepository
import by.yarik.cats_impl.mapper.CatsModelMapper
import by.yarik.cats_impl.model.CatsModel
import by.yarik.core.data.BaseRepositoryImpl
import by.yarik.core.network.Api
import io.reactivex.Single

class CatsRepositoryImpl(var api: Api) : BaseRepositoryImpl(), CatsRepository {

    override fun getAllCats(limit : Int) : Single<List<CatsModel>> {
        val data = HashMap<String, Any>()
        data.put("limit", limit)

        return api.getListOfCats(data).flatMap {
            CatsModelMapper.mapCatsModelItems(it)
        }
    }
}