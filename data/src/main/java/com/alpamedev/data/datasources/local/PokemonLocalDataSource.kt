package com.alpamedev.data.datasources.local

import com.alpamedev.domain.pokemon.Pokemon

interface PokemonLocalDataSource {
    suspend fun requestPokemon(id: Int): Pokemon?
    suspend fun requestPokemon(name: String): Pokemon?
    suspend fun insertPokemon(pokemon: Pokemon)
}