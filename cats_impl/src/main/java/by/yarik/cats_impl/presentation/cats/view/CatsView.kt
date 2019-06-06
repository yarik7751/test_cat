package by.yarik.cats_impl.presentation.cats.view

import by.yarik.cats_impl.viewmodel.CatsViewModel
import by.yarik.core.presentation.view.BaseView

interface CatsView : BaseView {

    fun updateCats(catsList : MutableList <CatsViewModel>)

    fun clearCatList()

    fun startProgress()

    fun stopProgress()

    fun sendSimpleMessage(message: String)
}