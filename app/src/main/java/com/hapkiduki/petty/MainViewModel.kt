package com.hapkiduki.petty

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hapkiduki.petty.data.repository.CatsRepository
import com.hapkiduki.petty.model.CatBreed
import com.hapkiduki.petty.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val catsRepository: CatsRepository
) : ViewModel() {

    var loading by mutableStateOf(false)
        private set

    var razas = mutableStateListOf<CatBreed>()
        private set

    init {
        getCatsBreeds()
    }

    fun getCatsBreeds() {
        viewModelScope.launch {
            catsRepository.getBreeds().also { result ->
                when (result) {
                    is Result.Error -> {
                        loading = false
                        Log.i("Datos", "getCatsBreeds: Error papa ${result.exception}")
                    }
                    Result.Loading -> loading = true
                    is Result.Success -> {
                        Log.i("Datos", "getCatsBreeds: ${result.data.toString()}")
                        razas.addAll(result.data)
                    }
                }
            }
        }
    }
}