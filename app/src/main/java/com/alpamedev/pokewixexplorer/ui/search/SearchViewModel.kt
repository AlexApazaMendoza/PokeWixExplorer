package com.alpamedev.pokewixexplorer.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alpamedev.domain.pokemon.Pokemon
import com.alpamedev.usecases.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val pokemonUseCase: GetPokemonUseCase): ViewModel() {

    private val _pokemon = MutableLiveData<Pokemon?>(null)
    val pokemon: LiveData<Pokemon?> = _pokemon

    private val _showProgressBar = MutableLiveData<Boolean>(false)
    val showProgressBar : MutableLiveData<Boolean> = _showProgressBar

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()
    }

    fun searchPokemon(namePokemon: String){
        _showProgressBar.value = true
        CoroutineScope(Dispatchers.IO+coroutineExceptionHandler).launch{
            _pokemon.postValue(pokemonUseCase.getPokemon(namePokemon))
            _showProgressBar.postValue(false)
        }
    }

}