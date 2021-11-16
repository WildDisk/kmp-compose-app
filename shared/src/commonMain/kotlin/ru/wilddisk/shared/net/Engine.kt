package ru.wilddisk.shared.net

import io.ktor.client.engine.*

expect class Engine() {
    fun create() : HttpClientEngineFactory<HttpClientEngineConfig>
}