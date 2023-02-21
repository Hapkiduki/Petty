package com.hapkiduki.network.di

import com.hapkiduki.network.api.RetrofitCatsNetworkApi
import com.hapkiduki.network.api.RetrofitDogsNetworkApi
import com.hapkiduki.network.Constants
import com.hapkiduki.network.interceptors.BaseUrlInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {

        return Retrofit.Builder()
            .baseUrl(Constants.DOG_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesHttpClient() = OkHttpClient
        .Builder()
        .addInterceptor(BaseUrlInterceptor)
        .build()

    @Provides
    fun providesCatsApiService(
        retrofit: Retrofit
    ): RetrofitCatsNetworkApi = retrofit.create(RetrofitCatsNetworkApi::class.java)

    @Provides
    fun providesDogsApiService(
        retrofit: Retrofit
    ): RetrofitDogsNetworkApi = retrofit.create(RetrofitDogsNetworkApi::class.java)
}