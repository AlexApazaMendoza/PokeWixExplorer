package com.alpamedev.data.datasources.remote

import com.alpamedev.domain.pokemon.Pokemon

interface PokemonRemoteDataSource {
    suspend fun requestPokemon(id: Int): Pokemon?
    suspend fun requestPokemon(name: String): Pokemon?
}