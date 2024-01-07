package com.alpamedev.pokewixexplorer.framework.db.room.entities.generation

import androidx.annotation.NonNull
import androidx.room.Entity
import com.alpamedev.domain.generation.Generation

@Entity(primaryKeys = ["name"])
data class GenerationEntity(
    @NonNull val name: String,
    val url: String
){
    fun toGeneration() = Generation(name, url)
}
