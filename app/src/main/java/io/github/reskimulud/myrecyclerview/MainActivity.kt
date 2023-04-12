package io.github.reskimulud.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.reskimulud.myrecyclerview.adapter.ListAlbumAdapter
import io.github.reskimulud.myrecyclerview.data.AlbumData.listData

class MainActivity : AppCompatActivity() {
    private lateinit var listAdapter: ListAlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listAdapter = ListAlbumAdapter()

        val rvAlbums: RecyclerView = findViewById(R.id.rv_albums)
        rvAlbums.layoutManager = LinearLayoutManager(this)
        rvAlbums.adapter = listAdapter

        listAdapter.setData(listData)
    }
}