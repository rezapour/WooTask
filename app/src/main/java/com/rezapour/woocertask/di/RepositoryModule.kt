package com.rezapour.woocertask.di

import com.rezapour.woocertask.data.network.ApiProvider
import com.rezapour.woocertask.data.network.ApiProviderimpl
import com.rezapour.woocertask.data.network.retrofit.ApiService
import com.rezapour.woocertask.data.repository.MainRepository
import com.rezapour.woocertask.data.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun provideApiHelper(apiService: ApiService): ApiProvider {
        return ApiProviderimpl(apiService)
    }

    @Singleton
    @Provides
    fun provideRepository(apiProvider: ApiProvider): MainRepository {
        return MainRepositoryImpl(apiProvider)
    }


}