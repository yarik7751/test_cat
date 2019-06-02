package by.yarik.cats_impl.domain

import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.domain.BaseInteractor
import io.reactivex.Single

interface CatsInteractor : BaseInteractor {

    fun getCats(limit : Int) : Single<List<CatsViewModel>>
}