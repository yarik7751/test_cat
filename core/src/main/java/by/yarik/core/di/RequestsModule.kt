package by.yarik.core.di

import android.content.Context
import androidx.room.Room
import by.yarik.core.AppContexProvider
import by.yarik.core.ResourceManager
import by.yarik.core.db.FavoriteCatsDatabase
import by.yarik.core.network.Api
import by.yarik.core.network.ApiImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RequestsModule {

    @Provides
    fun provideContext(): Context? {
        return AppContexProvider.getApplicationContext()!!
    }

    @Provides
    fun provideResourceManager(context: Context?): ResourceManager {
        return ResourceManager(context!!)
    }

    @Provides
    @Singleton
    fun provideApi(): Api {
        return ApiImpl.create()
    }

    @Provides
    @Singleton
    fun provideFavoriteCatsDatabase(context: Context?): FavoriteCatsDatabase {
        return Room.databaseBuilder(
            context!!,
            FavoriteCatsDatabase::class.java,
            FavoriteCatsDatabase.DB_NAME)
            .build()
    }
}