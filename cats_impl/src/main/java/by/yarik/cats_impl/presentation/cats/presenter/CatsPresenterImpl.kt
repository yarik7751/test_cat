package by.yarik.cats_impl.presentation.cats.presenter

import android.os.Bundle
import by.yarik.cats_impl.R
import by.yarik.cats_impl.di.CatsComponent
import by.yarik.cats_impl.domain.allcats.CatsInteractor
import by.yarik.cats_impl.presentation.cats.view.CatsView
import by.yarik.core.ResourceManager
import by.yarik.core.presentation.presenter.BasePresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class CatsPresenterImpl(view: CatsView) : BasePresenterImpl<CatsView>(view), CatsPresenter {

    companion object {
        const val DEFAULT_LIMIT = 10
    }

    @Inject
    lateinit var interactor: CatsInteractor

    @Inject
    lateinit var resourceManager: ResourceManager

    override fun onCreateView() {
        CatsComponent.getInstance().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getAllCats()
    }

    override fun addCatToFavoriteClick(url: String) {
        addCatToFavorite(url)
    }

    private fun getAllCats() {
        addCDisposable(interactor.getCats(DEFAULT_LIMIT)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.startProgress() }
            .doAfterTerminate { view.stopProgress() }
            .subscribe({
                view.updateCats(it)
            }, {onFailture(it)}))
    }

    private fun addCatToFavorite(url: String) {
        addCDisposable(interactor.addCatToFavorite(url)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                addCatToFavoriteSuccessful()
            }, {onFailture(it)}))
    }

    private fun addCatToFavoriteSuccessful() {
        view.sendSimpleMessage(resourceManager.getString(R.string.cat_added))
    }
}