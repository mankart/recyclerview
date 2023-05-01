package io.github.reskimulud.myrecyclerview.data

import io.github.reskimulud.myrecyclerview.model.Album

class AlbumRepository(private val albums: ArrayList<Album>) {

    fun getAlbums(): ArrayList<Album> = albums

    fun getAlbumById(id: Int): Album = albums.filter { it.id == id }[0]

    companion object {
        @Volatile
        private var INSTANCE: AlbumRepository? = null

        @JvmStatic
        fun getInstance(albums: ArrayList<Album>): AlbumRepository =
            INSTANCE ?: synchronized(this) {
                val instance = AlbumRepository(albums)
                INSTANCE = instance
                instance
            }
    }
}