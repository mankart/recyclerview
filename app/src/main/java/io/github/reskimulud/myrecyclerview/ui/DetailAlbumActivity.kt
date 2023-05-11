package io.github.reskimulud.myrecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import io.github.reskimulud.myrecyclerview.R
import io.github.reskimulud.myrecyclerview.ui.viewmodel.DetailAlbumViewModel
import io.github.reskimulud.myrecyclerview.ui.viewmodel.ViewModelFactory

class DetailAlbumActivity : AppCompatActivity() {
    private lateinit var factory: ViewModelFactory
    private val detailAlbumViewModel: DetailAlbumViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_album)

        factory = ViewModelFactory.getInstance()

        val ivAlbumPicture: ImageView = findViewById(R.id.iv_detail_album_picture)
        val tvTitle: TextView = findViewById(R.id.tv_detail_title)
        val tvArtist: TextView = findViewById(R.id.tv_detail_artist)
        val tvDescription: TextView = findViewById(R.id.tv_description)

        val albumId = intent.getIntExtra(EXTRA_ALBUM_ID, 0)
        detailAlbumViewModel.getAlbumById(albumId)

        // disini kita pasangkan data dari viewmodel ke layout
        detailAlbumViewModel.album.observe(this) {
            Glide.with(this@DetailAlbumActivity)
                .load(it.cover)
                .into(ivAlbumPicture)

            tvTitle.text = it.albumNames
            tvArtist.text = it.albumArtist
            tvDescription.text = it.description
        }
    }

    companion object {
        const val EXTRA_ALBUM_ID = "extra_album_id"
    }
}