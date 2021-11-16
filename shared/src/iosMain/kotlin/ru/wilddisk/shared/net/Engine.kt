package ru.wilddisk.shared.net

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*

actual class Engine {
    actual fun create() : HttpClientEngineFactory<HttpClientEngineConfig> = Ios
}