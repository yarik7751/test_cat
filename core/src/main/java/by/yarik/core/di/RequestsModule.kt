package by.yarik.core.di

import androidx.room.Room
import by.yarik.core.AppContexProvider
import by.yarik.core.db.FavoriteCatsDatabase
import by.yarik.core.network.Api
import by.yarik.core.network.ApiImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RequestsModule {

    @Provides
    @Singleton
    fun provideApi(): Api {
        return ApiImpl.create()
    }

    @Provides
    @Singleton
    fun provideFavoriteCatsDatabase(): FavoriteCatsDatabase {
        return Room.databaseBuilder(
            AppContexProvider.getApplicationContext()!!,
            FavoriteCatsDatabase::class.java,
            FavoriteCatsDatabase.DB_NAME)
            .build()
    }
}