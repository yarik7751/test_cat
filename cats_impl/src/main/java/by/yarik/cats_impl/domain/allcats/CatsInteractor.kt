package by.yarik.cats_impl.domain.allcats

import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.domain.BaseInteractor
import io.reactivex.Completable
import io.reactivex.Single

interface CatsInteractor : BaseInteractor {

    fun getCats(limit : Int) : Single<List<CatsViewModel>>

    fun downloadCatImage(url: String): Single<Boolean>

    fun addCatToFavorite(url: String): Completable

    fun getFavoriteCats(): Single<List<CatsViewModel>>
}