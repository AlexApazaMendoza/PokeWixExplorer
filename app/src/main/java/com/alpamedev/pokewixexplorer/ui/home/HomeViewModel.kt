package com.alpamedev.pokewixexplorer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alpamedev.domain.generation.Generation
import com.alpamedev.domain.pokemon.Pokemon
import com.alpamedev.usecases.GetGenerationUseCase
import com.alpamedev.usecases.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokemonUseCase: GetPokemonUseCase,
    private val generationUseCase: GetGenerationUseCase
): ViewModel() {

    private val _pokemonList = MutableLiveData<MutableList<Pokemon>>(mutableListOf())
    val pokemonList: LiveData<MutableList<Pokemon>> = _pokemonList

    private val _generationList = MutableLiveData<MutableList<Generation>>(mutableListOf())
    val generationList: LiveData<MutableList<Generation>> = _generationList

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()
    }

    private val coroutine = CoroutineScope(Dispatchers.IO+coroutineExceptionHandler)

    fun getPokemons(){
        coroutine.launch {
            val generations = generationUseCase.getGenerationList().toMutableList()
            _generationList.postValue(generations)
            generations.let {
                val generation = generationUseCase.getGeneration(it.first().name ?: "")
                generation?.let { value ->
                    val pokemonData = mutableListOf<Pokemon>()
                    value.pokemonSpecies.forEach { specie ->
                        pokemonUseCase.getPokemon(specie.name)?.let { pokemon ->
                            pokemonData.add(pokemon)
                            _pokemonList.postValue(pokemonData)
                        }
                    }
                }
            }
        }
    }

    fun onItemGenerationClick(generation: Generation){
        if(coroutine.isActive){
            coroutine.coroutineContext.cancelChildren()
        }
        coroutine.launch {
            getPokemonDataListByGeneration(generation)
        }
    }

    private suspend fun getPokemonDataListByGeneration(generation: Generation) {
        generationUseCase.getGeneration(generation.name ?: "")?.let {
            val pokemonData = mutableListOf<Pokemon>()
            it.pokemonSpecies.forEach { specie ->
                pokemonUseCase.getPokemon(specie.name)?.let { pokemon ->
                    pokemonData.add(pokemon)
                    _pokemonList.postValue(pokemonData)
                }
            }
        }
    }

}