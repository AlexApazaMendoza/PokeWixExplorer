package com.alpamedev.pokewixexplorer.ui.listeners

import com.alpamedev.domain.generation.Generation
import com.alpamedev.domain.pokemon.Pokemon

interface OnClickListener {
    fun onItemPokemonClick(pokemon: Pokemon)
    fun onItemGenerationClick(generation: Generation)
}