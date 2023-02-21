package com.hapkiduki.petty.data.repository

import com.hapkiduki.petty.data.model.asExternalModel
import com.hapkiduki.petty.data.network.api.RetrofitDogsNetworkApi
import com.hapkiduki.petty.model.DogBreed
import com.hapkiduki.petty.util.makeNetworkCall
import javax.inject.Inject

class DogsRepositoryImpl @Inject constructor(
    private val apiService: RetrofitDogsNetworkApi
) : DogsRepository {
    override suspend fun getBreeds(): com.hapkiduki.petty.util.Result<List<DogBreed>> =
        makeNetworkCall {
            apiService.getBreeds().map { it.asExternalModel() }
        }
}