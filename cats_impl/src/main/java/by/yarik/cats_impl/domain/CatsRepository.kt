package by.yarik.cats_impl.domain

import by.yarik.cats_impl.model.CatsModel
import by.yarik.core.domain.BaseRepository
import io.reactivex.Single

interface CatsRepository : BaseRepository {

    fun getAllCats(limit : Int) : Single<List<CatsModel>>
}