package by.yarik.core.network

import by.yarik.core.network.pojo.CatsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

@JvmSuppressWildcards
interface Api {

    @GET(ApiPaths.RECEIVE_LIST_OF_CATS)
    fun getListOfCats(@QueryMap data : Map<String, Any>): Single<List<CatsResponse>>
}