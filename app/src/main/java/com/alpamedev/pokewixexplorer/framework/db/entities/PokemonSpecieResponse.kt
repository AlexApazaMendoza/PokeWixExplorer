package com.alpamedev.pokewixexplorer.framework.db.entities

import com.google.gson.annotations.SerializedName

data class PokemonSpecieResponse(
    @SerializedName("color")
    val color: BaseResponse,
    @SerializedName("generation")
    val generation: BaseResponse,
    @SerializedName("id")
    val id: Long,       //1
    @SerializedName("name")
    val name: String,   //"bulbasaur"
    @SerializedName("varieties")
    val varieties: List<VarietyResult>
)

data class VarietyResult (
    @SerializedName("is_default")
    val isDefault: String,   //true
    @SerializedName("pokemon")
    val pokemon: BaseResponse
)