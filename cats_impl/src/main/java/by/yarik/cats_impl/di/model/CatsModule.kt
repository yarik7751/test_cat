package by.yarik.cats_impl.di.model

import by.yarik.cats_api.CatsStarter
import by.yarik.cats_impl.data.allcats.CatsRepositoryImpl
import by.yarik.cats_impl.domain.allcats.CatsInteractor
import by.yarik.cats_impl.domain.allcats.CatsInteractorImpl
import by.yarik.cats_impl.domain.allcats.CatsRepository
import by.yarik.cats_impl.start.CatsStarterImpl
import by.yarik.core.db.FavoriteCatsDatabase
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
    fun provideCatsRepository(api: Api, database: FavoriteCatsDatabase) : CatsRepository {
        return CatsRepositoryImpl(api, database)
    }

    @Provides
    fun provideCatsInteractor(repository: CatsRepository) : CatsInteractor {
        return CatsInteractorImpl(repository)
    }
}