package by.yarik.cats_impl.presentation.cats.view

import androidx.recyclerview.widget.LinearLayoutManager
import by.yarik.cats_impl.R
import by.yarik.cats_impl.presentation.cats.presenter.CatsPresenter
import by.yarik.cats_impl.presentation.cats.presenter.CatsPresenterImpl
import by.yarik.cats_impl.presentation.cats.view.adapter.CatsAdapter
import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.presentation.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_cats.*

class CatsFragment : BaseFragment<CatsPresenter>(), CatsView {

    override fun resourceLayout(): Int {
        return R.layout.fragment_cats
    }

    override fun initPresenter(): CatsPresenter {
        return CatsPresenterImpl(this)
    }

    override fun initUi() {
        catsListView.layoutManager = LinearLayoutManager(context)
    }

    override fun updateCats(catsList: List<CatsViewModel>) {
        val adapter = CatsAdapter(catsList)
        catsListView.adapter = adapter

        adapter.catsCallback = object : CatsAdapter.OnCatCallback {
            override fun onCatClick(url: String) {
                presenter.addCatToFavorite(url)
            }
        }
    }
}