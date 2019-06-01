package by.yarik.core.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import by.yarik.core.presentation.presenter.BasePresenter

abstract class BaseFragment<P : BasePresenter> : Fragment(), BaseView {

    protected lateinit var presenter: P

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(resourceLayout(), container, false)
        presenter = initPresenter()
        presenter.onCreateView()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.onActivityCreated(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    @LayoutRes
    protected abstract fun resourceLayout(): Int

    protected abstract fun initPresenter(): P
}