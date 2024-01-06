package com.alpamedev.usecases

import com.alpamedev.data.repositories.PokemonRepository
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {
    suspend fun getPokemon(id: Int) = pokemonRepository.getPokemon(id)
    suspend fun getPokemon(name: String) = pokemonRepository.getPokemon(name)
}