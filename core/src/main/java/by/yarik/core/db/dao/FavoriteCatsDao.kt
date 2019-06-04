package by.yarik.core.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.yarik.core.db.entity.FavoriteCatDb

@Dao
interface FavoriteCatsDao {

    @Insert
    fun addFavoriteCat(cat : FavoriteCatDb)

    @Query("SELECT * FROM favorite_cats")
    fun getAllFavoriteCats(): List<FavoriteCatDb>
}