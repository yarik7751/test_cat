package by.yarik.cats_impl.di

import by.yarik.cats_api.CatsApi
import by.yarik.cats_impl.di.model.CatsModule
import by.yarik.cats_impl.presentation.cats.presenter.CatsPresenterImpl
import by.yarik.cats_impl.presentation.favorite_cats.presentor.FavoriteCatsPresenterImpl
import by.yarik.core.di.RequestsModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RequestsModule::class, CatsModule::class])
@Singleton
abstract class CatsComponent : CatsApi {

    companion object {
        lateinit var catsComponent : CatsComponent

        fun init(component: CatsComponent) {
            catsComponent = component
        }

        fun getInstance() : CatsComponent{
            return catsComponent
        }
    }

    abstract fun inject(presenter: CatsPresenterImpl)

    abstract fun inject(presenter: FavoriteCatsPresenterImpl)
}
