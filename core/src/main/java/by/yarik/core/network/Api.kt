package by.yarik.core.network

import by.yarik.core.network.pojo.CatsResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url


@JvmSuppressWildcards
interface Api {

    @GET(ApiPaths.RECEIVE_LIST_OF_CATS)
    fun getListOfCats(@QueryMap data : Map<String, Any>): Single<List<CatsResponse>>

    @GET
    fun downloadFileWithUrl(@Url fileUrl: String): Single<ResponseBody>
}