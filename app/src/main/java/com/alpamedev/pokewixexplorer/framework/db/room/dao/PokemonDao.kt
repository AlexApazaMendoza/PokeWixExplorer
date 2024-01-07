package com.alpamedev.pokewixexplorer.framework.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.PokemonEntity

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemonentity WHERE id IN (:id)")
    suspend fun loadPokemonById(id: Int): PokemonEntity?

    @Query("SELECT * FROM pokemonentity WHERE name IN (:name)")
    suspend fun loadPokemonByName(name: String): PokemonEntity?

    @Insert
    suspend fun insertAll(vararg pokemon: PokemonEntity)
}