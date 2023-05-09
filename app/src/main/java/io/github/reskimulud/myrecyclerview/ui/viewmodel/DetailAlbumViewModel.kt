package io.github.reskimulud.myrecyclerview.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.reskimulud.myrecyclerview.data.AlbumRepository
import io.github.reskimulud.myrecyclerview.model.Album

class DetailAlbumViewModel(private val repository: AlbumRepository): ViewModel() {
    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album> = _album

    fun getAlbumById(albumId: Int) {
        _album.value = repository.getAlbumById(albumId)
    }
}