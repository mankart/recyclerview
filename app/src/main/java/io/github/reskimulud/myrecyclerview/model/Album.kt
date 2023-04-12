package io.github.reskimulud.myrecyclerview.model

data class Album(
    var id: Int = 0,
    var albumNames: String = "",
    var albumArtist: String = "",
    var year: String = "",
    var release: String = "",
    var songs: Int = 0,
    var duration: String = "",
    var genre: String = "",
    var description: String = "",
    var label: String = "",
    var cover: Int = 0,
)
