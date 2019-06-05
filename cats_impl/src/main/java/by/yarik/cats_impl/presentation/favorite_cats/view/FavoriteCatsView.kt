package by.yarik.cats_impl.presentation.favorite_cats.view

import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.presentation.view.BaseView

interface FavoriteCatsView: BaseView {

    fun updateFaviriteCats(cats: List<CatsViewModel>)
}