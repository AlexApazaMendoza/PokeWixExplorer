package com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon

import androidx.annotation.NonNull
import androidx.room.Entity
import com.alpamedev.domain.pokemon.Ability
import com.alpamedev.domain.pokemon.Move
import com.alpamedev.domain.pokemon.Pokemon
import com.alpamedev.domain.pokemon.Sprites
import com.alpamedev.domain.pokemon.Stat
import com.alpamedev.domain.pokemon.Type
import com.alpamedev.pokewixexplorer.framework.db.room.entities.BaseEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.specie.SpecieEntity

@Entity(primaryKeys = ["id"])
data class PokemonEntity(
    @NonNull val id: Long,
    val name: String,
    val baseExperience: Long,
    val weight: Long,
    val height: Long,
    val isDefault: Boolean,
    val order: Long,
    val abilities: List<AbilityEntity>,
    val moves: List<MoveEntity>,
    val species: SpecieEntity,
    val sprites: SpritesEntity,
    val stats: List<StatEntity>,
    val types: List<TypeEntity>
) {
    fun toPokemon() = Pokemon(
        id,
        name,
        baseExperience,
        weight,
        height,
        isDefault,
        order,
        abilities.map { it.toAbility() },
        moves.map { it.toMove() },
        species.toSpecie(),
        sprites.toSprites(),
        stats.map { it.toStat() },
        types.map { it.toType() }
    )
}

data class AbilityEntity(
    val slot: Long,
    val isHidden: Boolean,
    override val name: String,
    override val url: String
): BaseEntity() {
    fun toAbility() = Ability(slot, isHidden, name, url)
}

data class MoveEntity(
    override val name: String,
    override val url: String
): BaseEntity() {
    fun toMove() = Move(name, url)
}

data class SpritesEntity(
    val backDefault: String,
    val backFemale: String,
    val frontDefault: String,
    val frontFemale: String,
) {
    fun toSprites() = Sprites(backDefault, backFemale, frontDefault, frontFemale)
}

data class StatEntity (
    override val name: String,
    override val url: String,
    val baseStat: Long
): BaseEntity() {
    fun toStat() = Stat(name, url, baseStat)
}

data class TypeEntity(
    val slot: Long,
    override val name: String,
    override val url: String
): BaseEntity() {
    fun toType() = Type(slot, name, url)
}
