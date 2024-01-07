package com.alpamedev.pokewixexplorer.framework.db.api.entities

import com.alpamedev.domain.pokemon.Ability
import com.alpamedev.domain.pokemon.Move
import com.alpamedev.domain.pokemon.Pokemon
import com.alpamedev.domain.pokemon.Sprites
import com.alpamedev.domain.pokemon.Stat
import com.alpamedev.domain.pokemon.Type
import com.alpamedev.domain.specie.Specie
import com.google.gson.annotations.SerializedName

data class PokemonResponse (
    val id: Long,
    val name: String,
    @SerializedName("base_experience")
    val baseExperience: Long,
    val height: Long,
    @SerializedName("is_default")
    val isDefault: Boolean,
    val order: Long,
    val weight: Long,
    val abilities: List<AbilityResponse>,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String, //"https://pokeapi.co/api/v2/pokemon/252/encounters"
    val moves: List<MoveResponse>,
    val species: BaseResponse,
    val sprites: SpritesResponse,
    val stats: List<StatResponse>,
    val types: List<TypeResponse>
){
    fun toPokemon(): Pokemon {
        return Pokemon(
            id = id,
            name = name,
            baseExperience = baseExperience,
            weight = weight,
            height = height,
            isDefault = isDefault,
            order = order,
            abilities = abilities.map { it.toAbility() },
            moves = moves.map { it.toMove() },
            species = Specie(species.name, species.url),
            sprites = sprites.toSprites(),
            stats = stats.map { it.toStat() },
            types = types.map { it.toType() }
        )
    }
}

data class TypeResponse(
    val slot: Long,
    val type: BaseResponse,
){
    fun toType(): Type {
        return Type(
            slot =  slot,
            name = type.name,
            url = type.url
        )
    }
}

data class AbilityResponse (
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    val slot: Long,
    val ability: BaseResponse
){
    fun toAbility(): Ability {
        return Ability(
            slot = slot,
            isHidden = isHidden,
            name = ability.name,
            url = ability.url
        )
    }
}

data class MoveResponse (
    val move: BaseResponse,
){
    fun toMove(): Move {
        return Move(
            name = move.name,
            url = move.url
        )
    }
}

data class SpritesResponse (
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_female")
    val backFemale: String? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("back_shiny_female")
    val backShinyFemale: String? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_female")
    val frontFemale: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String? = null
){
    fun toSprites(): Sprites {
        return Sprites(
            backDefault = backDefault ?: "",
            backFemale = backFemale ?: "",
            frontDefault = frontDefault ?: "",
            frontFemale = frontFemale ?: ""
        )
    }
}

data class StatResponse (
    @SerializedName("base_stat")
    val baseStat: Long,
    val effort: Long,
    val stat: BaseResponse
){
    fun toStat(): Stat {
        return Stat(
            name = stat.name,
            url = stat.url,
            baseStat = baseStat
        )
    }
}