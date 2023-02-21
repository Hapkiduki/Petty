package com.hapkiduki.petty.data.repository

import com.hapkiduki.petty.model.DogBreed
import com.hapkiduki.petty.util.Result

interface DogsRepository {
    /**
     * Get all dogs breeds
     */
    suspend fun getBreeds(): Result<List<DogBreed>>
}