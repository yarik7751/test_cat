package by.yarik.cats_impl.presentation.cats.view

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.yarik.cats_impl.R
import by.yarik.cats_impl.presentation.cats.presenter.CatsPresenter
import by.yarik.cats_impl.presentation.cats.presenter.CatsPresenterImpl
import by.yarik.cats_impl.presentation.cats.view.adapter.CatsAdapter
import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.presentation.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_cats.*

class CatsFragment : BaseFragment<CatsPresenter>(), CatsView {

    lateinit var adapter: CatsAdapter

    override fun resourceLayout(): Int {
        return R.layout.fragment_cats
    }

    override fun initPresenter(): CatsPresenter {
        return CatsPresenterImpl(this)
    }

    override fun initUi() {
        catsListView.layoutManager = LinearLayoutManager(context)

        updateList.setOnClickListener {
            presenter.onUpdateListClick()
        }
    }

    override fun updateCats(catsList: MutableList <CatsViewModel>) {
        adapter = CatsAdapter(catsList)
        catsListView.adapter = adapter

        adapter.catsCallback = object : CatsAdapter.OnCatCallback {
            override fun onDownloadClick(url: String) {
                presenter.downloadFile(url, permission)
            }

            override fun onCatClick(url: String) {
                presenter.addCatToFavoriteClick(url)
            }
        }
    }

    override fun clearCatList() {
        adapter.clear()
    }

    override fun startProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun stopProgress() {
        progressBar.visibility = View.GONE
    }
}