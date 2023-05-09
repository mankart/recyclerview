package io.github.reskimulud.myrecyclerview.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.reskimulud.myrecyclerview.data.AlbumRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: AlbumRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailAlbumViewModel::class.java) -> {
                DetailAlbumViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Model tidak ditemukan")
        }
    }
}