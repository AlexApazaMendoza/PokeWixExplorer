package com.alpamedev.pokewixexplorer.framework.db.api.entities

import com.alpamedev.domain.generation.ResultGeneration
import com.alpamedev.domain.specie.Specie
import com.google.gson.annotations.SerializedName

data class GenerationResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("main_region")
    val mainRegion: BaseResponse,
    @SerializedName("name")
    val name: String,   //"generation-i"
    @SerializedName("pokemon_species")
    val pokemonSpecies: List<BaseResponse>
){
    fun toResultGeneration() = ResultGeneration(id, name, pokemonSpecies.map { Specie(it.name, it.url) })
}
