package by.yarik.cats_impl.presentation.favorite_cats.view

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.yarik.cats_impl.R
import by.yarik.cats_impl.presentation.favorite_cats.presentor.FavoriteCatsPresenter
import by.yarik.cats_impl.presentation.favorite_cats.presentor.FavoriteCatsPresenterImpl
import by.yarik.cats_impl.presentation.favorite_cats.view.adapter.FavoriteCatsAdapter
import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.presentation.view.BaseFragment
import kotlinx.android.synthetic.main.fragmet_favorite_cats.*

class FavoriteCatsFragment: BaseFragment<FavoriteCatsPresenter>(), FavoriteCatsView {


    override fun resourceLayout(): Int {
        return R.layout.fragmet_favorite_cats
    }

    override fun initPresenter(): FavoriteCatsPresenter {
        return FavoriteCatsPresenterImpl(this)
    }

    override fun initUi() {
        favoriteCatsListView.layoutManager = LinearLayoutManager(context)
    }

    override fun startProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun stopProgress() {
        progressBar.visibility = View.GONE
    }

    override fun updateFaviriteCats(cats: List<CatsViewModel>) {
        val adapter = FavoriteCatsAdapter(cats)
        favoriteCatsListView.adapter = adapter
    }
}