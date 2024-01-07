package com.alpamedev.data.datasources.remote

import com.alpamedev.domain.generation.Generation
import com.alpamedev.domain.generation.ResultGeneration

interface GenerationRemoteDataSource {
    suspend fun requestGenerationList(): List<Generation>
    suspend fun requestGeneration(id: Int): ResultGeneration?
    suspend fun requestGeneration(name: String): ResultGeneration?
}