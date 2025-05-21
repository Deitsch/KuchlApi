package io.github.kotlin.fibonacci

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.serialization.json.Json

@OptIn(ExperimentalCoroutinesApi::class, InternalCoroutinesApi::class)
@Suppress("unused")
fun forceLinkSymbols() {
    // Reference something internal to prevent DCE from pruning it
    kotlinx.coroutines.internal.LockFreeLinkedListHead().forEach {}
}

interface PokeApi {
    suspend fun getPokemon(): PokemonListResponse
}

class RemotePokeApi : PokeApi {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json { ignoreUnknownKeys = true },
                contentType = ContentType.Application.Json
            )
        }
    }

    override suspend fun getPokemon(): PokemonListResponse {
        return client.get("https://pokeapi.co/api/v2/pokemon").body()
    }
}