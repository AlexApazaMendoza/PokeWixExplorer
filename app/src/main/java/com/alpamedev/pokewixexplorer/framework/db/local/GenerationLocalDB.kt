package com.alpamedev.pokewixexplorer.framework.db.local

import com.alpamedev.data.datasources.local.GenerationLocalDataSource
import com.alpamedev.domain.generation.Generation
import com.alpamedev.domain.generation.ResultGeneration
import com.alpamedev.pokewixexplorer.framework.db.room.AppDataBase
import com.alpamedev.pokewixexplorer.framework.db.room.dao.GenerationDao
import com.alpamedev.pokewixexplorer.framework.db.room.dao.ResultGenerationDao
import com.alpamedev.pokewixexplorer.framework.db.room.toGenerationEntity
import com.alpamedev.pokewixexplorer.framework.db.room.toResultGenerationEntity
import javax.inject.Inject

class GenerationLocalDB @Inject constructor(private val generationDao: GenerationDao, private val resultGenerationDao: ResultGenerationDao): GenerationLocalDataSource {
    override suspend fun requestGenerationList(): List<Generation> {
        return generationDao.loadAllGenerations().map { it.toGeneration() }
    }

    override suspend fun requestGeneration(id: Int): ResultGeneration? {
        return resultGenerationDao.loadPokemonById(id)?.toResultGeneration()
    }

    override suspend fun requestGeneration(name: String): ResultGeneration? {
        return resultGenerationDao.loadPokemonByName(name)?.toResultGeneration()
    }

    override suspend fun insertGeneration(generation: Generation) {
        generationDao.insertAll(generation.toGenerationEntity())
    }

    override suspend fun insertResultGeneration(resultGeneration: ResultGeneration) {
        resultGenerationDao.insertAll(resultGeneration.toResultGenerationEntity())
    }
}