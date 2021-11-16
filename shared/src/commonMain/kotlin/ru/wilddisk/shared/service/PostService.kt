package me.zolotopupie.shared.service

import kotlinx.coroutines.runBlocking
import ru.wilddisk.shared.model.Post
import ru.wilddisk.shared.net.HttpClient

class PostService(
    private val client: HttpClient,
    private val post: Post = Post()
) {
    fun post(): Post {
        val result = runBlocking { client.result(post.id) }
        return Post(
            id = result["id"]?.toLong() ?: -1,
            userId = result["userId"]?.toLong() ?: -1,
            title = result["title"] ?: "",
            body = result["body"] ?: ""
        )
    }

    fun posts(): List<Post> {
        val list = mutableListOf<Post>()
        val result = runBlocking { client.results() }
        result.forEach {
            list.add(
                Post(
                    id = it["id"]?.toLong() ?: -1,
                    userId = it["userId"]?.toLong() ?: -1,
                    title = it["title"] ?: "",
                    body = it["body"] ?: ""
                )
            )
        }
        return list
    }
}