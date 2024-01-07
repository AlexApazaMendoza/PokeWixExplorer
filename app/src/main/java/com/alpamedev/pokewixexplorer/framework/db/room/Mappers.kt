package com.alpamedev.pokewixexplorer.framework.db.room

import com.alpamedev.domain.generation.Generation
import com.alpamedev.domain.generation.ResultGeneration
import com.alpamedev.domain.pokemon.Ability
import com.alpamedev.domain.pokemon.Move
import com.alpamedev.domain.pokemon.Pokemon
import com.alpamedev.domain.pokemon.Sprites
import com.alpamedev.domain.pokemon.Stat
import com.alpamedev.domain.pokemon.Type
import com.alpamedev.domain.specie.Specie
import com.alpamedev.pokewixexplorer.framework.db.room.entities.generation.GenerationEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.generation.ResultGenerationEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.AbilityEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.MoveEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.PokemonEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.SpritesEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.StatEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.TypeEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.specie.SpecieEntity

fun ResultGeneration.toResultGenerationEntity(): ResultGenerationEntity {
    return ResultGenerationEntity(
        id = id,
        name = name,
        pokemonSpecies = pokemonSpecies.map { it.toSpecieEntity() }
    )
}

fun Specie.toSpecieEntity(): SpecieEntity {
    return SpecieEntity(
        name = name,
        url = url
    )
}

fun Generation.toGenerationEntity(): GenerationEntity {
    return GenerationEntity(
        name = name ?: "",
        url = url ?: ""
    )
}

fun Pokemon.toPokemonEntity(): PokemonEntity {
    return PokemonEntity(
        id = id,
        name = name,
        baseExperience = baseExperience,
        weight = weight,
        height = height,
        isDefault = isDefault,
        order = order,
        abilities = abilities.map { it.toAbilityEntity() },
        moves = moves.map { it.toMoveEntity() },
        species = species.toSpecieEntity(),
        sprites = sprites.toSpritesEntity(),
        stats = stats.map { it.toStatEntity() },
        types = types.map { it.toTypeEntity() }
    )
}

fun Ability.toAbilityEntity(): AbilityEntity {
    return AbilityEntity(
        slot = slot,
        isHidden = isHidden,
        name = name,
        url = url
    )
}

fun Move.toMoveEntity(): MoveEntity {
    return MoveEntity(
        name = name,
        url = url
    )
}

fun Sprites.toSpritesEntity(): SpritesEntity {
    return SpritesEntity(
        backDefault = backDefault,
        backFemale = backFemale,
        frontDefault = frontDefault,
        frontFemale = frontFemale
    )
}

fun Stat.toStatEntity(): StatEntity {
    return StatEntity(
        name = name,
        url = url,
        baseStat = baseStat,
    )
}

fun Type.toTypeEntity(): TypeEntity {
    return TypeEntity(
        slot = slot,
        name = name,
        url = url
    )
}


























