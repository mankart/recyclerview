package io.github.reskimulud.myrecyclerview.data

import io.github.reskimulud.myrecyclerview.model.Album

class AlbumRepository(private val albums: ArrayList<Album>) {
    fun getAlbums(): ArrayList<Album> {
        return albums
    }

    fun getAlbumById(albumId: Int): Album {
        return albums.filter { it.id == albumId }[0]
    }
}