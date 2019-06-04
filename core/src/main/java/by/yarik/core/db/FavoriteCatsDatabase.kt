package by.yarik.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import by.yarik.core.db.dao.FavoriteCatsDao
import by.yarik.core.db.entity.FavoriteCatDb

@Database(entities = arrayOf(FavoriteCatDb::class), version = 1)
abstract class FavoriteCatsDatabase: RoomDatabase() {

    companion object {
        const val DB_NAME = "cats_db";
    }

    abstract fun getFavoriteCatsDao(): FavoriteCatsDao
}