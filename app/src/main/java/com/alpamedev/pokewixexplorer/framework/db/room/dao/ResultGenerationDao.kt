package com.alpamedev.pokewixexplorer.framework.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alpamedev.pokewixexplorer.framework.db.room.entities.generation.ResultGenerationEntity

@Dao
interface ResultGenerationDao {
    @Query("SELECT * FROM resultgenerationentity WHERE id IN (:id)")
    suspend fun loadPokemonById(id: Int): ResultGenerationEntity?

    @Query("SELECT * FROM resultgenerationentity WHERE name IN (:name)")
    suspend fun loadPokemonByName(name: String): ResultGenerationEntity?

    @Insert
    suspend fun insertAll(vararg resultGeneration: ResultGenerationEntity)
}