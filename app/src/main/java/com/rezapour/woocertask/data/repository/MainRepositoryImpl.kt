package com.rezapour.woocertask.data.repository

import com.rezapour.woocertask.data.database.CacheMapper
import com.rezapour.woocertask.data.database.dao.ProductDao
import com.rezapour.woocertask.data.network.ApiProvider
import com.rezapour.woocertask.data.network.NetworkMapper
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow
import javax.inject.Inject

class MainRepositoryImpl constructor(
    private val apiProvider: ApiProvider,
    private val dao: ProductDao,
    private val networkMapper: NetworkMapper,
    private val chacheMapper: CacheMapper
) : MainRepository {

    override suspend fun getProducts() {

    }


}