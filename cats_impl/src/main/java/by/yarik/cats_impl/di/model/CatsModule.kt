package by.yarik.cats_impl.di.model

import by.yarik.cats_api.CatsStarter
import by.yarik.cats_impl.data.CatsRepositoryImpl
import by.yarik.cats_impl.domain.CatsInteractor
import by.yarik.cats_impl.domain.CatsInteractorImpl
import by.yarik.cats_impl.domain.CatsRepository
import by.yarik.cats_impl.start.CatsStarterImpl
import by.yarik.core.network.Api
import dagger.Module
import dagger.Provides

@Module
class CatsModule {

    @Provides
    fun provideCatsStarter() : CatsStarter {
        return CatsStarterImpl()
    }

    @Provides
    fun provideCatsRepository(api: Api) : CatsRepository {
        return CatsRepositoryImpl(api)
    }

    @Provides
    fun provideCatsInteractor(repository: CatsRepository) : CatsInteractor {
        return CatsInteractorImpl(repository)
    }
}