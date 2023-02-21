package com.hapkiduki.petty.di

import com.hapkiduki.petty.data.repository.CatsRepository
import com.hapkiduki.petty.data.repository.CatsRepositoryImpl
import com.hapkiduki.petty.data.repository.DogsRepository
import com.hapkiduki.petty.data.repository.DogsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsDogsRepository(
        dogsRepository: DogsRepositoryImpl
    ): DogsRepository

    @Binds
    fun bindsCatsRepository(
        catsRepository: CatsRepositoryImpl
    ): CatsRepository
}