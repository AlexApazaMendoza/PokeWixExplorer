package com.alpamedev.pokewixexplorer.framework.db.api.entities

data class PokemonListResponse(
    val count: Long,
    val next: String? = null,
    val previous: String? = null,
    val results: List<BaseResponse>
)