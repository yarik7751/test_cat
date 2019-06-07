package by.yarik.cats_impl.presentation.favorite_cats.presentor

import by.yarik.core.presentation.presenter.BasePresenter
import com.tbruyelle.rxpermissions2.RxPermissions

interface FavoriteCatsPresenter: BasePresenter{

    fun downloadFile(url: String, permissions: RxPermissions)
}