package com.alpamedev.data.datasources.local

import com.alpamedev.domain.generation.Generation
import com.alpamedev.domain.generation.ResultGeneration

interface GenerationLocalDataSource {
    suspend fun requestGenerationList(): List<Generation>
    suspend fun requestGeneration(id: Int): ResultGeneration?
    suspend fun requestGeneration(name: String): ResultGeneration?
    suspend fun insertGeneration(generation: Generation)
    suspend fun insertResultGeneration(resultGeneration: ResultGeneration)
}