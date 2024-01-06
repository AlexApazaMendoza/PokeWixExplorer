package com.alpamedev.data.repositories

import com.alpamedev.data.datasources.PokemonRemoteDataSource

class PokemonRepository(private val pokemonRemoteDataSource: PokemonRemoteDataSource) {
    suspend fun getPokemon(id: Int) = pokemonRemoteDataSource.requestPokemon(id)
    suspend fun getPokemon(name: String) = pokemonRemoteDataSource.requestPokemon(name)
}