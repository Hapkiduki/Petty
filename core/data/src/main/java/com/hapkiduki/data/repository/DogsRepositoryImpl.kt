package com.hapkiduki.data.repository

import com.hapkiduki.common.Result
import com.hapkiduki.common.makeNetworkCall
import com.hapkiduki.data.model.asExternalModel
import com.hapkiduki.model.DogBreed
import com.hapkiduki.network.api.RetrofitDogsNetworkApi
import javax.inject.Inject

class DogsRepositoryImpl @Inject constructor(
    private val apiService: RetrofitDogsNetworkApi
) : DogsRepository {
    override suspend fun getBreeds(): Result<List<DogBreed>> =
        makeNetworkCall {
            apiService.getBreeds().map { it.asExternalModel() }
        }
}