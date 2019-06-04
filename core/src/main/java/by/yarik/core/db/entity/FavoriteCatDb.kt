package by.yarik.core.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_cats")
data class FavoriteCatDb(@PrimaryKey(autoGenerate = true) var id: Long, var url: String)