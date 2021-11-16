package ru.wilddisk.shared.net

import io.ktor.client.engine.*
import io.ktor.client.engine.android.*

actual class Engine {
    actual fun create(): HttpClientEngineFactory<HttpClientEngineConfig> = Android.apply {
        create {
            AndroidEngineConfig().apply {
                connectTimeout = 100_000
                socketTimeout = 100_000
            }
        }
    }
}