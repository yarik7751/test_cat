package by.yarik.test_cat

import android.app.Application
import by.yarik.cats_impl.di.CatsComponent
import by.yarik.cats_impl.di.DaggerCatsComponent
import by.yarik.core.AppContexProvider

class CatsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        AppContexProvider.setApplicationContext(applicationContext)
        CatsComponent.init(DaggerCatsComponent.builder().build())
    }
}