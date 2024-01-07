package com.alpamedev.domain.generation

import com.alpamedev.domain.specie.Specie

data class ResultGeneration(
    val id: Long,
    val name: String,
    val pokemonSpecies: List<Specie>
)
