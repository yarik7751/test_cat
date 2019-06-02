package by.yarik.cats_impl.mapper

import by.yarik.cats_impl.model.CatsModel
import by.yarik.cats_impl.viewmodel.CatsViewModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.Function

object CatsViewModelMapper {

    fun mapCatsViewModelItems(responses: List<CatsModel>) :Single<List<CatsViewModel>> {
        return Observable.fromIterable(responses)
            .map(mappingCatsModelIntem())
            .toList()
    }

    private fun mappingCatsModelIntem(): Function<CatsModel, CatsViewModel> {
        return Function {
            return@Function CatsViewModel(it.url, it.id)
        }
    }
}