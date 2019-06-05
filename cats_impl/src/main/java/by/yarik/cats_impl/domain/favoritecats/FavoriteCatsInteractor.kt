package by.yarik.cats_impl.domain.favoritecats

import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.domain.BaseInteractor
import io.reactivex.Single

interface FavoriteCatsInteractor: BaseInteractor {

    fun getFavoriteCats(): Single<List<CatsViewModel>>
}