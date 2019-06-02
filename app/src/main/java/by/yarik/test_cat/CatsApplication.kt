package by.yarik.test_cat

import android.app.Application
import by.yarik.cats_impl.di.CatsComponent
import by.yarik.cats_impl.di.DaggerCatsComponent

class CatsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        CatsComponent.init(DaggerCatsComponent.builder().build())
    }
}