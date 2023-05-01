package io.github.reskimulud.myrecyclerview.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.reskimulud.myrecyclerview.ui.adapter.ListAlbumAdapter
import io.github.reskimulud.myrecyclerview.databinding.ActivityMainBinding
import io.github.reskimulud.myrecyclerview.ui.viewmodel.MainViewModel
import io.github.reskimulud.myrecyclerview.ui.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAlbumAdapter
    private lateinit var rvAlbums: RecyclerView
    private lateinit var factory: ViewModelFactory
    private val viewModel: MainViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        factory = ViewModelFactory.getInstance()

        listAdapter = ListAlbumAdapter { albumId ->
            val intent = Intent(this, DetailAlbum::class.java)
            intent.putExtra(DetailAlbum.EXTRA_ALBUM_ID, albumId)
            startActivity(intent)
        }
        rvAlbums = binding.rvAlbums

        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvAlbums.layoutManager = LinearLayoutManager(this)
        rvAlbums.adapter = listAdapter

        viewModel.albums.observe(this) {
            listAdapter.setData(it)
        }
    }
}