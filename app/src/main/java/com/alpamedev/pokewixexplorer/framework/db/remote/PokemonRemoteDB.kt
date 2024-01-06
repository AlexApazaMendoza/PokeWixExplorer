package com.alpamedev.pokewixexplorer.framework.db.remote

import com.alpamedev.data.datasources.PokemonRemoteDataSource
import com.alpamedev.domain.pokemon.Pokemon
import com.alpamedev.pokewixexplorer.framework.db.RetrofitConfig
import javax.inject.Inject

class PokemonRemoteDB @Inject constructor(private val retrofitConfig: RetrofitConfig): PokemonRemoteDataSource {
    override suspend fun requestPokemon(id: Int): Pokemon? {
        val response = retrofitConfig.pokemonService.searchPokemonById(id)
        if (response.isSuccessful) {
            return response.body()?.toPokemon()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun requestPokemon(name: String): Pokemon? {
        val response = retrofitConfig.pokemonService.searchPokemonByName(name)
        if (response.isSuccessful) {
            return response.body()?.toPokemon()
        } else {
            throw Exception(response.message())
        }
    }
}