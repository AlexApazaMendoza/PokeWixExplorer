package com.alpamedev.domain.pokemon

import com.alpamedev.domain.specie.Specie

data class Pokemon(
    val id: Long,
    val name: String,
    val baseExperience: Long,
    val weight: Long,
    val height: Long,
    val isDefault: Boolean,
    val order: Long,
    val abilities: List<Ability>,
    val moves: List<Move>,
    val species: Specie,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>
)
