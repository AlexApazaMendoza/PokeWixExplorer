package com.alpamedev.pokewixexplorer

import com.alpamedev.pokewixexplorer.models.PokemonResponse
import com.alpamedev.pokewixexplorer.models.ResultGeneration

interface OnClickListener {
    fun onItemPokemonClick(pokemon: PokemonResponse)
    fun onItemGenerationClick(generation: ResultGeneration)
}