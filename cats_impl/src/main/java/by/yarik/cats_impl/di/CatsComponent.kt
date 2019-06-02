package by.yarik.cats_impl.di

import by.yarik.cats_api.CatsApi
import by.yarik.cats_impl.di.model.CatsModule
import by.yarik.cats_impl.presentation.cats.presenter.CatsPresenterImpl
import by.yarik.core.network.di.RequestsModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RequestsModule::class, CatsModule::class])
@Singleton
abstract class CatsComponent : CatsApi {

    companion object {
        public lateinit var catsComponent : CatsComponent

        public fun init(component: CatsComponent) {
            catsComponent = component
        }

        public fun getInstance() : CatsComponent{
            return catsComponent
        }
    }

    public abstract fun inject(catsPresenterImpl: CatsPresenterImpl)
}
