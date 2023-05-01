package io.github.reskimulud.myrecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import io.github.reskimulud.myrecyclerview.databinding.ActivityDetailAlbumBinding
import io.github.reskimulud.myrecyclerview.ui.viewmodel.DetailAlbumViewModel
import io.github.reskimulud.myrecyclerview.ui.viewmodel.ViewModelFactory

class DetailAlbum : AppCompatActivity() {
    private lateinit var binding: ActivityDetailAlbumBinding
    private lateinit var factory: ViewModelFactory
    private val viewModel: DetailAlbumViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        factory = ViewModelFactory.getInstance()

        val albumId = intent.getIntExtra(EXTRA_ALBUM_ID, 0)
        viewModel.getAlbumById(albumId)

        bindData()
    }

    private fun bindData() {
        viewModel.album.observe(this) {
            binding.apply {
                tvDetailTitle.text = it.albumNames
                tvDetailArtist.text = it.albumArtist
                tvDescription.text = it.description

                Glide.with(this@DetailAlbum)
                    .load(it.cover)
                    .into(ivDetailAlbumPicture)
            }

            supportActionBar?.title = it.albumNames
        }
    }

    companion object {
        const val EXTRA_ALBUM_ID = "extra_album_id"
    }
}