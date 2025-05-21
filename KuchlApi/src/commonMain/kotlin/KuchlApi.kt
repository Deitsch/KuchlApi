package io.github.kotlin.fibonacci

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path

interface MenuApi {
    suspend fun getMenu(): List<MenuWeek>
}

class KuchlApi : MenuApi {
    private val client = HttpClient()

    override suspend fun getMenu(): List<MenuWeek> {
        return client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = "jsonplaceholder.typicode.com"
                path("/posts")
            }
        }.body()
    }
}
