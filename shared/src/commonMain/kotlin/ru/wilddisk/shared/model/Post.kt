package ru.wilddisk.shared.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Long = -1,
    val userId: Long = -1,
    val title: String = "",
    val body: String = ""
)