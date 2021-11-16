package ru.wilddisk.shared.net

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

class HttpClient(private val url: String) {
    private val client = HttpClient(Engine().create()) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }
    suspend fun results(): List<Map<String, String>> {
        val list = client.get<List<Map<String, String>>>(url)
        client.close()
        return list
    }
    suspend fun result(id: Long): Map<String, String> {
        val result = client.get<Map<String, String>>(
            if (url.last() == "/".toCharArray()[0]) {
                this.url + id
            } else {
                "${this.url}/$id"
            }
        )
        client.close()
        return result
    }
}