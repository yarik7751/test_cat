package by.yarik.cats_impl.presentation.cats.view

import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.presentation.view.BaseView

interface CatsView : BaseView {

    fun updateCats(catsList : List<CatsViewModel>)

    fun sendSimpleMessage(message: String)
}