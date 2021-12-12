package com.rezapour.woocertask.di

import com.rezapour.woocertask.data.database.CacheMapper
import com.rezapour.woocertask.data.database.dao.ProductDao
import com.rezapour.woocertask.data.network.ApiProvider
import com.rezapour.woocertask.data.network.ApiProviderimpl
import com.rezapour.woocertask.data.network.NetworkMapper
import com.rezapour.woocertask.data.network.retrofit.ApiService
import com.rezapour.woocertask.data.repository.MainRepository
import com.rezapour.woocertask.data.repository.MainRepositoryImpl
import com.rezapour.woocertask.model.product.Product
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
    fun provideRepository(
        apiProvider: ApiProvider,
        dao: ProductDao,
        networkMapper: NetworkMapper,
        cacheMapper: CacheMapper
    ): MainRepository {
        return MainRepositoryImpl(apiProvider,dao,networkMapper,cacheMapper)
    }


}