package by.yarik.cats_impl.domain.favoritecats

import by.yarik.cats_impl.model.CatsModel
import by.yarik.core.domain.BaseRepository
import io.reactivex.Single

interface FavoriteCatsRepository: BaseRepository {

    fun getFavoriteCats(): Single<List<CatsModel>>
}