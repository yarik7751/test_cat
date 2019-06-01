package by.yarik.core.network

import by.yarik.core.network.pojo.CatsResponse
import io.reactivex.Single

interface Api {

    fun getListOfCats(): Single<List<CatsResponse>>
}