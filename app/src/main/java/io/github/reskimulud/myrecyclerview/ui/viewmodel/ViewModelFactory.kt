package io.github.reskimulud.myrecyclerview.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.reskimulud.myrecyclerview.data.AlbumRepository
import io.github.reskimulud.myrecyclerview.di.Injection

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: AlbumRepository,
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailAlbumViewModel::class.java) -> {
                DetailAlbumViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("ViewModel ${modelClass.name} tidak diketahui")
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(): ViewModelFactory =
            INSTANCE ?: synchronized(this) {
                val albumRepository = Injection.provideRepository()
                val instance = ViewModelFactory(albumRepository)
                INSTANCE = instance
                instance
            }
    }
}