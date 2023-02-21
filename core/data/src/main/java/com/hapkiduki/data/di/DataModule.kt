package com.hapkiduki.data.di


import com.hapkiduki.data.repository.CatsRepository
import com.hapkiduki.data.repository.CatsRepositoryImpl
import com.hapkiduki.data.repository.DogsRepository
import com.hapkiduki.data.repository.DogsRepositoryImpl
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