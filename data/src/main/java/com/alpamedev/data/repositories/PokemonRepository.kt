package com.alpamedev.data.repositories

import com.alpamedev.data.datasources.local.PokemonLocalDataSource
import com.alpamedev.data.datasources.remote.PokemonRemoteDataSource
import com.alpamedev.domain.pokemon.Pokemon
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokemonRemoteDataSource: PokemonRemoteDataSource, private val pokemonLocalDataSource: PokemonLocalDataSource) {
    suspend fun getPokemon(id: Int): Pokemon? {
        val local = pokemonLocalDataSource.requestPokemon(id)
        return if (local == null) {
            val remote = pokemonRemoteDataSource.requestPokemon(id)
            if (remote != null) {
                pokemonLocalDataSource.insertPokemon(remote)
            }
            remote
        } else {
            local
        }
    }
    suspend fun getPokemon(name: String): Pokemon? {
        val local = pokemonLocalDataSource.requestPokemon(name)
        return if (local == null) {
            val remote = pokemonRemoteDataSource.requestPokemon(name)
            if (remote != null) {
                pokemonLocalDataSource.insertPokemon(remote)
            }
            remote
        } else {
            local
        }
    }
}