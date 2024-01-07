package com.alpamedev.pokewixexplorer.framework.db.room.entities.generation

import androidx.annotation.NonNull
import androidx.room.Entity
import com.alpamedev.domain.generation.ResultGeneration
import com.alpamedev.pokewixexplorer.framework.db.room.entities.specie.SpecieEntity

@Entity(primaryKeys = ["id"])
data class ResultGenerationEntity(
    @NonNull val id: Long,
    val name: String,
    val pokemonSpecies: List<SpecieEntity>
) {
    fun toResultGeneration() = ResultGeneration(id, name, pokemonSpecies.map { it.toSpecie() })
}
