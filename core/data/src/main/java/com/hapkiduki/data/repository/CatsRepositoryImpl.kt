package com.hapkiduki.data.repository

import com.hapkiduki.common.makeNetworkCall
import com.hapkiduki.common.Result
import com.hapkiduki.data.model.asExternalModel
import com.hapkiduki.model.CatBreed
import com.hapkiduki.network.api.RetrofitCatsNetworkApi
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val apiService: RetrofitCatsNetworkApi
) : CatsRepository {
    override suspend fun getBreeds(): Result<List<CatBreed>> =
        makeNetworkCall {
            apiService.getBreeds().map { it.asExternalModel() }
        }
}