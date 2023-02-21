package com.hapkiduki.petty.data.network.api

import com.hapkiduki.petty.data.network.Api
import com.hapkiduki.petty.data.network.ApiType
import com.hapkiduki.petty.data.network.model.NetworkDogBreed
import com.hapkiduki.petty.util.Constants
import retrofit2.http.GET

@Api(ApiType.DOGS)
interface RetrofitDogsNetworkApi {
    @GET(Constants.BREEDS_URL)
    suspend fun getBreeds() : List<NetworkDogBreed>
}