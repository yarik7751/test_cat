package by.yarik.cats_impl.domain.favoritecats

import by.yarik.cats_impl.mapper.CatsViewModelMapper
import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.domain.BaseInteractorImpl
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class FavoriteCatsInteractorImpl(var repository: FavoriteCatsRepository): BaseInteractorImpl(), FavoriteCatsInteractor {

    override fun getFavoriteCats(): Single<List<CatsViewModel>> {
        return repository.getFavoriteCats()
            .flatMap {
                return@flatMap CatsViewModelMapper.mapCatsViewModelItems(it)
            }
            .subscribeOn(Schedulers.io())
    }
}