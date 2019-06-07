package by.yarik.core.presentation.presenter

import by.yarik.core.presentation.view.BaseView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenterImpl<V : BaseView>(var view: V) : BasePresenter {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    protected fun onFailture(throwable: Throwable) {

    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }
}