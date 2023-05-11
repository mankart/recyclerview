package io.github.reskimulud.myrecyclerview.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.reskimulud.myrecyclerview.R
import io.github.reskimulud.myrecyclerview.model.Album

class ListAlbumAdapter(private val onClickCallback: (albumId: Int) -> Unit): RecyclerView.Adapter<ListAlbumAdapter.ViewHolder>() {
    private val listAlbum: ArrayList<Album> = arrayListOf()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val ivAlbumPicture: ImageView = itemView.findViewById(R.id.iv_album_picture)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        private val tvArtist: TextView = itemView.findViewById(R.id.tv_artist)
        private val tvYear: TextView = itemView.findViewById(R.id.tv_year)

        fun bind(data: Album) {
            data.apply {
                Glide.with(itemView.context)
                    .load(cover)
                    .into(ivAlbumPicture)
                tvTitle.text = albumNames
                tvArtist.text = albumArtist
                tvYear.text = year
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listAlbum.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listAlbum[position]
        holder.bind(data)

        holder.itemView.setOnClickListener {
            onClickCallback(data.id)
        }
    }

    fun setData(data: ArrayList<Album>) {
        listAlbum.clear()
        listAlbum.addAll(data)
        notifyDataSetChanged()
    }
}