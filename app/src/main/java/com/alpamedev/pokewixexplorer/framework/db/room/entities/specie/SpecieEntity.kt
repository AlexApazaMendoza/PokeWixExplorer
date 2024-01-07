package com.alpamedev.pokewixexplorer.framework.db.room.entities.specie

import com.alpamedev.domain.specie.Specie
import com.alpamedev.pokewixexplorer.framework.db.room.entities.BaseEntity

data class SpecieEntity(
    override val name: String,
    override val url: String
): BaseEntity() {
    fun toSpecie() = Specie(name, url)
}
