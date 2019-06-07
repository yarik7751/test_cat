package by.yarik.core.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import by.yarik.core.presentation.presenter.BasePresenter
import com.tbruyelle.rxpermissions2.RxPermissions

abstract class BaseFragment<P : BasePresenter> : Fragment(), BaseView {

    protected lateinit var presenter: P
    protected lateinit var permission: RxPermissions

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        permission = RxPermissions(this)
        val view = inflater.inflate(resourceLayout(), container, false)
        presenter = initPresenter()
        presenter.onCreateView()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.onActivityCreated(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun sendSimpleMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @LayoutRes
    protected abstract fun resourceLayout(): Int

    protected abstract fun initPresenter(): P
}