package com.alpamedev.usecases

import com.alpamedev.data.repositories.GenerationRepository
import javax.inject.Inject

class GetGenerationUseCase @Inject constructor(private val generationRepository: GenerationRepository) {
    suspend fun getGenerationList() = generationRepository.getGenerationList()
    suspend fun getGeneration(id: Int) = generationRepository.getGeneration(id)
    suspend fun getGeneration(name: String) = generationRepository.getGeneration(name)
}