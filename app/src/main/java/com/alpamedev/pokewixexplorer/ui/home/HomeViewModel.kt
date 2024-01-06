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

    var job: Job? = null

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()
    }

    init {
        _pokemonList.value = mutableListOf()
    }

    fun getPokemons(){
        CoroutineScope(Dispatchers.IO+coroutineExceptionHandler).launch {
            _generationList.postValue(generationUseCase.getGenerationList().toMutableList())
            job = CoroutineScope(Dispatchers.IO+coroutineExceptionHandler).launch{
                _generationList.value?.let {
                    val generation = generationUseCase.getGeneration(it.first().name ?: "")
                    generation?.let { gen ->
                        val pokemonData = mutableListOf<Pokemon>()
                        gen.pokemonSpecies.forEach { spe ->
                            pokemonUseCase.getPokemon(spe.name)?.let { poke ->
                                pokemonData.add(poke)
                            }
                        }
                        _pokemonList.postValue(pokemonData)
                    }
                }
            }
        }
    }

    fun onItemGenerationClick(generation: Generation){
        if(job != null){
            if(job!!.isActive){
                job!!.cancel()
                job = null
            }
        }
        job = CoroutineScope(Dispatchers.IO+coroutineExceptionHandler).launch{
            getPokemonDataListByGeneration(generation)
        }
    }

    private suspend fun getPokemonDataListByGeneration(generation: Generation) {
        generationUseCase.getGeneration(generation.name ?: "")?.let { gen ->
            val pokemonData = mutableListOf<Pokemon>()
            gen.pokemonSpecies.forEach { spe ->
                pokemonUseCase.getPokemon(spe.name)?.let { poke ->
                    pokemonData.add(poke)
                }
            }
            _pokemonList.postValue(pokemonData)
        }
    }

}