package by.yarik.cats_impl.presentation.favorite_cats.presentor

import android.os.Bundle
import by.yarik.cats_impl.di.CatsComponent
import by.yarik.cats_impl.domain.favoritecats.FavoriteCatsInteractor
import by.yarik.cats_impl.presentation.favorite_cats.view.FavoriteCatsView
import by.yarik.core.presentation.presenter.BasePresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class FavoriteCatsPresenterImpl(view: FavoriteCatsView): BasePresenterImpl<FavoriteCatsView>(view), FavoriteCatsPresenter {

    @Inject
    lateinit var interactor: FavoriteCatsInteractor

    override fun onCreateView() {
        CatsComponent.getInstance().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getFavoriteCats()
    }

    private fun getFavoriteCats() {
        addCDisposable(interactor.getFavoriteCats()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.startProgress() }
            .doAfterTerminate { view.stopProgress() }
            .subscribe({
                view.updateFaviriteCats(it as MutableList)
            }, {onFailture(it)}))
    }
}