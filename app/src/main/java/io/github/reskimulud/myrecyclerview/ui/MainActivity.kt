package io.github.reskimulud.myrecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.reskimulud.myrecyclerview.R
import io.github.reskimulud.myrecyclerview.ui.adapter.ListAlbumAdapter
import io.github.reskimulud.myrecyclerview.data.AlbumData.listData
import io.github.reskimulud.myrecyclerview.ui.viewmodel.MainViewModel
import io.github.reskimulud.myrecyclerview.ui.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var listAdapter: ListAlbumAdapter
    private lateinit var rvAlbums: RecyclerView

    private lateinit var factory: ViewModelFactory
    private val mainViewModel: MainViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        factory = ViewModelFactory.getInstance()

        listAdapter = ListAlbumAdapter()
        rvAlbums = findViewById(R.id.rv_albums)

        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvAlbums.layoutManager = LinearLayoutManager(this)
        rvAlbums.adapter = listAdapter

        // listAdapter.setData(listData)
        mainViewModel.albums.observe(this) {
            listAdapter.setData(it)
        }
    }
}