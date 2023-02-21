package com.hapkiduki.data.repository

import com.hapkiduki.model.CatBreed
import com.hapkiduki.common.Result

interface CatsRepository {
    /**
     * Get all cats breeds
     */
    suspend fun getBreeds(): Result<List<CatBreed>>
}