package by.yarik.cats_impl.presentation.favorite_cats.view.adapter

import android.view.View
import by.yarik.cats_impl.presentation.cats.view.adapter.CatsAdapter
import by.yarik.cats_impl.viewmodel.CatsViewModel

class FavoriteCatsAdapter(cats : List<CatsViewModel>): CatsAdapter(cats) {

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.btnAddCatTofavorite.visibility = View.GONE
    }
}