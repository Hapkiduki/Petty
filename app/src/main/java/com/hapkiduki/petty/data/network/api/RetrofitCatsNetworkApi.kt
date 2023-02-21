package com.hapkiduki.petty.data.network.api

import com.hapkiduki.petty.data.network.Api
import com.hapkiduki.petty.data.network.ApiType
import com.hapkiduki.petty.data.network.model.NetworkCatBreed
import com.hapkiduki.petty.util.Constants
import retrofit2.http.GET

interface RetrofitCatsNetworkApi {
    @GET(Constants.BREEDS_URL)
    @Api(ApiType.CATS)
    suspend fun getBreeds(): List<NetworkCatBreed>
}