package io.github.reskimulud.myrecyclerview.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.reskimulud.myrecyclerview.data.AlbumRepository
import io.github.reskimulud.myrecyclerview.injection.Injection

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

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(): ViewModelFactory {
            return INSTANCE ?: synchronized(this) {
                val repository = Injection.provideRepository()
                val instance = ViewModelFactory(repository)
                INSTANCE = instance
                instance
            }
        }
    }
}