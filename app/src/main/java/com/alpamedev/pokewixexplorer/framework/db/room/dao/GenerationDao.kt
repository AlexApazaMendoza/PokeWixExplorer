package com.alpamedev.pokewixexplorer.framework.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alpamedev.pokewixexplorer.framework.db.room.entities.generation.GenerationEntity

@Dao
interface GenerationDao {
    @Query("SELECT * FROM generationentity")
    suspend fun loadAllGenerations(): List<GenerationEntity>

    @Insert
    suspend fun insertAll(vararg generation: GenerationEntity)
}