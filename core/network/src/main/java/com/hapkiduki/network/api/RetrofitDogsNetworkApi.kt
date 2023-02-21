package com.hapkiduki.network.api

import com.hapkiduki.network.Api
import com.hapkiduki.network.ApiType
import com.hapkiduki.network.Constants
import com.hapkiduki.network.model.NetworkDogBreed
import retrofit2.http.GET

interface RetrofitDogsNetworkApi {
    @Api(ApiType.DOGS)
    @GET(Constants.BREEDS_URL)
    suspend fun getBreeds(): List<NetworkDogBreed>
}