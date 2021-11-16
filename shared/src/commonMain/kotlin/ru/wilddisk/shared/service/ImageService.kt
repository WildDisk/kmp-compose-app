package me.zolotopupie.shared.service

import kotlinx.coroutines.runBlocking
import ru.wilddisk.shared.model.Image
import ru.wilddisk.shared.net.HttpClient

class ImageService(
    private val client: HttpClient,
    private val image: Image
) {
    fun image(): Image {
        val result = runBlocking { client.result(image.id) }
        return Image(
            id = result["id"]?.toLong() ?: -1,
            albumId = result["albumId"]?.toLong() ?: -1,
            title = result["title"] ?: "",
            url = result["url"] ?: "",
            thumbnailUrl = result["thumbnailUrl"] ?: ""
        )
    }

    fun images(): List<Image> {
        val list = mutableListOf<Image>()
        val result = runBlocking { client.results() }
        result.forEach {
            list.add(
                Image(
                    id = it["id"]?.toLong() ?: -1,
                    albumId = it["albumId"]?.toLong() ?: -1,
                    title = it["title"] ?: "",
                    url = it["url"] ?: "",
                    thumbnailUrl = it["thumbnailUrl"] ?: ""
                )
            )
        }
        return list
    }
}