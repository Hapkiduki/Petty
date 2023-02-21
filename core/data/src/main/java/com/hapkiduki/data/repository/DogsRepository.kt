package com.hapkiduki.data.repository

import com.hapkiduki.common.Result
import com.hapkiduki.model.DogBreed


interface DogsRepository {
    /**
     * Get all dogs breeds
     */
    suspend fun getBreeds(): Result<List<DogBreed>>
}