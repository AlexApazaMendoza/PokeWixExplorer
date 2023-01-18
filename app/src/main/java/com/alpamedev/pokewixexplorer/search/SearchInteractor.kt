package com.alpamedev.pokewixexplorer.search

import android.util.Log
import com.alpamedev.pokewixexplorer.models.PokemonResponse
import com.alpamedev.pokewixexplorer.retrofit.RetrofitConfig

class SearchInteractor {

    suspend fun searchPokemonByName(namePokemon:String, callback:(pokemon:PokemonResponse) -> Unit){
        val call = RetrofitConfig.pokemonService.searchPokemonByName(namePokemon)
        val response = call.body()
        if(call.isSuccessful){
            if (response != null){
                callback(response)
            }
        } else {
            Log.i("TestAlex","Error - searchPokemonByName")
        }
    }
}