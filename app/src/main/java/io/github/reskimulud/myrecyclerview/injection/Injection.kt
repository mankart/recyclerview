package io.github.reskimulud.myrecyclerview.injection

import io.github.reskimulud.myrecyclerview.data.AlbumData
import io.github.reskimulud.myrecyclerview.data.AlbumRepository

object Injection {
    fun provideRepository(): AlbumRepository {
        val albumsData = AlbumData.listData
        return AlbumRepository.getInstance(albumsData)
    }
}