package io.github.reskimulud.myrecyclerview.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.reskimulud.myrecyclerview.data.AlbumRepository
import io.github.reskimulud.myrecyclerview.model.Album

class MainViewModel(private val repository: AlbumRepository): ViewModel() {
    private val _albums = MutableLiveData<ArrayList<Album>>()
    val album: LiveData<ArrayList<Album>> = _albums

    init {
        _albums.value = repository.getAlbums()
    }
}