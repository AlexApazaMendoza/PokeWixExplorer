package com.alpamedev.pokewixexplorer.framework.db.local

import com.alpamedev.data.datasources.local.PokemonLocalDataSource
import com.alpamedev.domain.pokemon.Pokemon
import com.alpamedev.pokewixexplorer.framework.db.room.dao.PokemonDao
import com.alpamedev.pokewixexplorer.framework.db.room.toPokemonEntity
import javax.inject.Inject

class PokemonLocalDB @Inject constructor(private val pokemonDao: PokemonDao): PokemonLocalDataSource {
    override suspend fun requestPokemon(id: Int): Pokemon? {
        return pokemonDao.loadPokemonById(id)?.toPokemon()
    }

    override suspend fun requestPokemon(name: String): Pokemon? {
        return pokemonDao.loadPokemonByName(name)?.toPokemon()
    }

    override suspend fun insertPokemon(pokemon: Pokemon) {
        pokemonDao.insertAll(pokemon.toPokemonEntity())
    }
}