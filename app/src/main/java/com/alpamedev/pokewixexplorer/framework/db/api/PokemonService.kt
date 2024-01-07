package com.alpamedev.pokewixexplorer.framework.db.api

import com.alpamedev.pokewixexplorer.framework.db.api.entities.GenerationListResponse
import com.alpamedev.pokewixexplorer.framework.db.api.entities.GenerationResponse
import com.alpamedev.pokewixexplorer.framework.db.api.entities.PokemonResponse
import com.alpamedev.pokewixexplorer.framework.db.api.entities.PokemonSpecieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    /*@GET("pokemon/")
    suspend fun searchPokemonList(): Response<PokemonListResponse>*/

    /*@GET("pokemon")
    suspend fun searchPokemonListParams(@Query("offset") offset:Int,@Query("limit") limit:Int): Response<PokemonListResponse>*/

    @GET("pokemon/{id}/")
    suspend fun searchPokemonById(@Path("id") id:Int): Response<PokemonResponse>

    @GET("pokemon/{name}/")
    suspend fun searchPokemonByName(@Path("name") name:String): Response<PokemonResponse>

    @GET("generation/")
    suspend fun searchGenerationList(): Response<GenerationListResponse>

    @GET("generation/{name}/")
    suspend fun searchGenerationByName(@Path("name") name:String): Response<GenerationResponse>

    @GET("generation/{id}/")
    suspend fun searchGenerationById(@Path("id") id:Int): Response<GenerationResponse>

    @GET("pokemon-species/{id}/")
    suspend fun searchPokemonSpeciesById(@Path("id") id:Int): Response<PokemonSpecieResponse>

    @GET("pokemon-species/{name}/")
    suspend fun searchPokemonSpeciesByName(@Path("name") name:String): Response<PokemonSpecieResponse>
}