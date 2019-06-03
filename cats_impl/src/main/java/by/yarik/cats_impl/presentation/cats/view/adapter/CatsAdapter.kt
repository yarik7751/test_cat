package by.yarik.cats_impl.presentation.cats.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.yarik.cats_impl.R
import by.yarik.cats_impl.viewmodel.CatsViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_cat.view.*

class CatsAdapter(var cats : List<CatsViewModel>) : RecyclerView.Adapter<CatsAdapter.CatsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        val url = cats[position].url
        Glide
            .with(holder.itemView.context)
            .load(url)
            .centerCrop()
            .into(holder.ivCat);
    }

    override fun getItemCount(): Int {
        return cats.size
    }

    class CatsViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var ivCat = view.catsImage
    }
}