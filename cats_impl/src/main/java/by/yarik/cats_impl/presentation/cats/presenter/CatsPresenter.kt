package by.yarik.cats_impl.presentation.cats.presenter

import by.yarik.core.presentation.presenter.BasePresenter
import com.tbruyelle.rxpermissions2.RxPermissions

interface CatsPresenter : BasePresenter {

    fun onUpdateListClick()

    fun addCatToFavoriteClick(url : String)

    fun downloadFile(url: String, permissions: RxPermissions)
}