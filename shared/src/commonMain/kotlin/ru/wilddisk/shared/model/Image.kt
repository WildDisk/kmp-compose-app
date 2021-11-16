package ru.wilddisk.shared.model

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val id: Long = -1,
    val albumId: Long = -1,
    val title: String = "",
    val url: String = "",
    val thumbnailUrl: String = ""
)
