package ru.wilddisk.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import ru.wilddisk.androidApp.ui.compose.Conversation
import ru.wilddisk.shared.net.HttpClient
import me.zolotopupie.shared.service.PostService
import ru.wilddisk.androidApp.ui.theme.KtorComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorComposeTheme {
                Conversation(
                    posts = PostService(
                        HttpClient("https://jsonplaceholder.typicode.com/posts")
                    ).posts()
                )
            }
        }
    }
}
