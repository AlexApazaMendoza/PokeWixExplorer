package com.alpamedev.data.repositories

import com.alpamedev.data.datasources.GenerationRemoteDataSource

class GenerationRepository(private val generationRemoteDataSource: GenerationRemoteDataSource) {
    suspend fun getGenerationList() = generationRemoteDataSource.requestGenerationList()
    suspend fun getGeneration(id: Int) = generationRemoteDataSource.requestGeneration(id)
    suspend fun getGeneration(name: String) = generationRemoteDataSource.requestGeneration(name)
}