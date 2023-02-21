package com.hapkiduki.petty.data.repository

import com.hapkiduki.petty.model.CatBreed
import com.hapkiduki.petty.util.Result

interface CatsRepository {
    /**
     * Get all cats breeds
     */
    suspend fun getBreeds(): Result<List<CatBreed>>
}