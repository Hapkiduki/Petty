package com.hapkiduki.network.api

import com.hapkiduki.network.Api
import com.hapkiduki.network.ApiType
import com.hapkiduki.network.Constants
import com.hapkiduki.network.model.NetworkCatBreed
import retrofit2.http.GET

interface RetrofitCatsNetworkApi {
    @GET(Constants.BREEDS_URL)
    @Api(ApiType.CATS)
    suspend fun getBreeds(): List<NetworkCatBreed>
}