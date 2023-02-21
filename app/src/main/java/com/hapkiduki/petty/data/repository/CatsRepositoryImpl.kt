package com.hapkiduki.petty.data.repository

import com.hapkiduki.petty.data.model.asExternalModel
import com.hapkiduki.petty.data.network.api.RetrofitCatsNetworkApi
import com.hapkiduki.petty.model.CatBreed
import com.hapkiduki.petty.util.makeNetworkCall
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val apiService: RetrofitCatsNetworkApi
) : CatsRepository {
    override suspend fun getBreeds(): com.hapkiduki.petty.util.Result<List<CatBreed>> =
        makeNetworkCall {
            apiService.getBreeds().map { it.asExternalModel() }
        }
}