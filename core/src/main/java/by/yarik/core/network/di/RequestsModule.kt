package by.yarik.core.network.di

import by.yarik.core.network.Api
import by.yarik.core.network.ApiImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RequestsModule {

    @Provides
    @Singleton
    public fun provideApi(): Api {
        return ApiImpl.create()
    }
}