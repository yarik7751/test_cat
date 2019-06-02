package by.yarik.cats_impl.presentation.cats.presenter

import android.os.Bundle
import by.yarik.cats_impl.di.CatsComponent
import by.yarik.cats_impl.domain.CatsInteractor
import by.yarik.cats_impl.presentation.cats.view.CatsView
import by.yarik.core.presentation.presenter.BasePresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class CatsPresenterImpl(view: CatsView) : BasePresenterImpl<CatsView>(view), CatsPresenter {

    companion object {
        const val DEFAULT_LIMIT = 10
    }

    @Inject
    lateinit var interactor: CatsInteractor

    override fun onCreateView() {
        CatsComponent.getInstance().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getAllCats()
    }

    private fun getAllCats() {
        addCDisposable(interactor.getCats(DEFAULT_LIMIT)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.updateCats(it)
            }, {onFailture(it)}))
    }
}