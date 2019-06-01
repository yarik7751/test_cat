package by.yarik.core.presentation.presenter

import by.yarik.core.ResourceManager
import by.yarik.core.presentation.view.BaseView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenterImpl<V : BaseView>(var view: BaseView, var resourceManager: ResourceManager) : BasePresenter {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun addCDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }
}