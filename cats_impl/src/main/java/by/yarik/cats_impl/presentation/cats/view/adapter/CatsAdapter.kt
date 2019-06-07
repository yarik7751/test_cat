package by.yarik.cats_impl.presentation.cats.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.yarik.cats_impl.R
import by.yarik.cats_impl.viewmodel.CatsViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_cat.view.*

open class CatsAdapter(var cats : MutableList<CatsViewModel>) : RecyclerView.Adapter<CatsAdapter.CatsViewHolder>() {

    lateinit var catsCallback : OnCatCallback

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

        holder.btnAddCatTofavorite.setOnClickListener {
            catsCallback.onCatClick(url)
        }

        holder.btnDownload.setOnClickListener {
            catsCallback.onDownloadClick(url)
        }
    }

    override fun getItemCount(): Int {
        return cats.size
    }

    fun clear() {
        val size = cats.size
        cats.clear()
        notifyItemRangeRemoved(0, size)
    }

    class CatsViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var ivCat = view.catsImage
        var btnAddCatTofavorite = view.addToFavorite
        var btnDownload = view.download
    }

    interface OnCatCallback {
        fun onCatClick(url: String)

        fun onDownloadClick(url: String)
    }
}