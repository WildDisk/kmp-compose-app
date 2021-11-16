package ru.wilddisk.androidApp.ui.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.wilddisk.shared.net.HttpClient
import ru.wilddisk.shared.model.Post
import me.zolotopupie.shared.service.PostService
import ru.wilddisk.androidApp.ui.theme.KtorComposeTheme

@Composable
fun Conversation(posts: List<Post>) {
    LazyColumn {
        items(posts) { post ->
            PostCard(post = post)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConversation() {
    KtorComposeTheme {
        Conversation(
            posts = PostService(
                HttpClient("https://jsonplaceholder.typicode.com/posts")
            ).posts()
        )
    }
}