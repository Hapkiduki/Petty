package com.hapkiduki.petty

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hapkiduki.data.repository.CatsRepository
import com.hapkiduki.common.Result
import com.hapkiduki.data.repository.DogsRepository
import com.hapkiduki.model.CatBreed
import com.hapkiduki.model.DogBreed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val catsRepository: CatsRepository,
    private val dogsRepository: DogsRepository
) : ViewModel() {

    var perrosActivos by mutableStateOf(false)
        private set

    var loading by mutableStateOf(false)
        private set

    var gatos = mutableStateListOf<CatBreed>()
        private set

    var perros = mutableStateListOf<DogBreed>()
        private set

    fun getDogsBreeds() {
        perrosActivos = true
        loading = true
        viewModelScope.launch {
            dogsRepository.getBreeds().also { result ->
                when(result) {
                    is Result.Error -> {
                        loading = false
                        Log.i("Datos", "getDogsBreeds: Error papa ${result.exception}")
                    }
                    Result.Loading -> loading = true
                    is Result.Success -> {
                        loading = false
                        Log.i("Datos", "getDogsBreeds: ${result.data.toString()}")
                        perros.addAll(result.data)
                    }
                }
            }
        }
    }

    fun getCatsBreeds() {
        perrosActivos = false
        loading = true
        viewModelScope.launch {
            catsRepository.getBreeds().also { result ->
                when (result) {
                    is Result.Error -> {
                        loading = false
                        Log.i("Datos", "getCatsBreeds: Error papa ${result.exception}")
                    }
                    Result.Loading -> loading = true
                    is Result.Success -> {
                        loading = false
                        Log.i("Datos", "getCatsBreeds: ${result.data.toString()}")
                        gatos.addAll(result.data)
                    }
                }
            }
        }
    }
}