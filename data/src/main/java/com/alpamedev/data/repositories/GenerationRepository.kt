package com.alpamedev.data.repositories

import com.alpamedev.data.datasources.local.GenerationLocalDataSource
import com.alpamedev.data.datasources.remote.GenerationRemoteDataSource
import com.alpamedev.domain.generation.Generation
import com.alpamedev.domain.generation.ResultGeneration
import javax.inject.Inject

class GenerationRepository @Inject constructor(private val generationRemoteDataSource: GenerationRemoteDataSource, private val generationLocalDataSource: GenerationLocalDataSource) {
    suspend fun getGenerationList(): List<Generation> {
        val local = generationLocalDataSource.requestGenerationList()
        return if (local.isEmpty()) {
            val remote = generationRemoteDataSource.requestGenerationList()
            if (remote.isNotEmpty()) {
                remote.forEach {
                    generationLocalDataSource.insertGeneration(it)
                }
            }
            remote
        } else {
            local
        }
    }
    suspend fun getGeneration(id: Int): ResultGeneration? {
        val local = generationLocalDataSource.requestGeneration(id)
        return if (local == null) {
            val remote = generationRemoteDataSource.requestGeneration(id)
            if (remote != null) {
                generationLocalDataSource.insertResultGeneration(remote)
            }
            remote
        } else {
            local
        }
    }
    suspend fun getGeneration(name: String): ResultGeneration? {
        val local = generationLocalDataSource.requestGeneration(name)
        return if (local == null) {
            val remote = generationRemoteDataSource.requestGeneration(name)
            if (remote != null) {
                generationLocalDataSource.insertResultGeneration(remote)
            }
            remote
        } else {
            local
        }
    }
}