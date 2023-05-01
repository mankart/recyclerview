package io.github.reskimulud.myrecyclerview.di

import io.github.reskimulud.myrecyclerview.data.AlbumData.listData
import io.github.reskimulud.myrecyclerview.data.AlbumRepository

object Injection {
    fun provideRepository() : AlbumRepository {
        val albums = listData
        return AlbumRepository.getInstance(albums)
    }
}