package io.github.reskimulud.myrecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.reskimulud.myrecyclerview.R
import io.github.reskimulud.myrecyclerview.ui.adapter.ListAlbumAdapter
import io.github.reskimulud.myrecyclerview.data.AlbumData.listData

class MainActivity : AppCompatActivity() {
    private lateinit var listAdapter: ListAlbumAdapter
    private lateinit var rvAlbums: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listAdapter = ListAlbumAdapter()
        rvAlbums = findViewById(R.id.rv_albums)

        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvAlbums.layoutManager = LinearLayoutManager(this)
        rvAlbums.adapter = listAdapter

        listAdapter.setData(listData)
    }
}