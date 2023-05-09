package io.github.reskimulud.myrecyclerview.injection

import io.github.reskimulud.myrecyclerview.data.AlbumData
import io.github.reskimulud.myrecyclerview.data.AlbumRepository

object Injection {
    fun provideRepository(): AlbumRepository {
        val albums = AlbumData.listData
        return AlbumRepository.getInstance(albums)
    }
}