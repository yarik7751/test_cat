package by.yarik.cats_impl.presentation.cats.presenter

import by.yarik.core.presentation.presenter.BasePresenter

interface CatsPresenter : BasePresenter {

    fun onUpdateListClick()

    fun addCatToFavoriteClick(url : String)
}