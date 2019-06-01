package by.yarik.core.presentation.presenter

import android.os.Bundle

interface BasePresenter {

    fun onCreateView()

    fun onActivityCreated(savedInstanceState: Bundle?)

    fun onDestroy()
}