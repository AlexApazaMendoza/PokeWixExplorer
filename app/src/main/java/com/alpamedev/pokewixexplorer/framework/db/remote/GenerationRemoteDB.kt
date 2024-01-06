package com.alpamedev.pokewixexplorer.framework.db.remote

import com.alpamedev.data.datasources.GenerationRemoteDataSource
import com.alpamedev.domain.Base
import com.alpamedev.domain.generation.Generation
import com.alpamedev.domain.generation.ResultGeneration
import com.alpamedev.pokewixexplorer.framework.db.RetrofitConfig

class GenerationRemoteDB(private val retrofitConfig: RetrofitConfig): GenerationRemoteDataSource {
    override suspend fun requestGenerationList(): List<Generation> {
        val response = retrofitConfig.pokemonService.searchGenerationList()
        if (response.isSuccessful) {
            return response.body()?.toGenerations() ?: emptyList()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun requestGeneration(id: Int): ResultGeneration? {
        val response = retrofitConfig.pokemonService.searchGenerationById(id)
        if (response.isSuccessful) {
            return response.body()?.toResultGeneration()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun requestGeneration(name: String): ResultGeneration? {
        val response = retrofitConfig.pokemonService.searchGenerationByName(name)
        if (response.isSuccessful) {
            return response.body()?.toResultGeneration()
        } else {
            throw Exception(response.message())
        }
    }
}