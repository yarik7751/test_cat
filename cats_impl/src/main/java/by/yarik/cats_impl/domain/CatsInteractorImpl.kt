package by.yarik.cats_impl.domain

import by.yarik.cats_impl.mapper.CatsViewModelMapper
import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.domain.BaseInteractorImpl
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class CatsInteractorImpl(var repository: CatsRepository) : BaseInteractorImpl(), CatsInteractor {

    override fun getCats(limit : Int) : Single<List<CatsViewModel>> {
        return repository.getAllCats(limit)
            .flatMap { CatsViewModelMapper.mapCatsViewModelItems(it) }
            .subscribeOn(Schedulers.io())
    }
}