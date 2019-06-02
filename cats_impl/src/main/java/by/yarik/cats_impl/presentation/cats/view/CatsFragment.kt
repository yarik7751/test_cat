package by.yarik.cats_impl.presentation.cats.view

import by.yarik.cats_impl.R
import by.yarik.cats_impl.presentation.cats.presenter.CatsPresenter
import by.yarik.cats_impl.presentation.cats.presenter.CatsPresenterImpl
import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.presentation.view.BaseFragment

class CatsFragment : BaseFragment<CatsPresenter>(), CatsView {

    override fun resourceLayout(): Int {
        return R.layout.fragment_cats
    }

    override fun initPresenter(): CatsPresenter {
        return CatsPresenterImpl(this)
    }

    override fun initUi() {

    }

    override fun updateCats(catsList: List<CatsViewModel>) {

    }
}