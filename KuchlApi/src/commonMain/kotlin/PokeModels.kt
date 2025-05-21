package io.github.kotlin.fibonacci

import kotlinx.serialization.Serializable

@Serializable
data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonSummary>
)

@Serializable
data class PokemonSummary(
    val name: String,
    val url: String
)
