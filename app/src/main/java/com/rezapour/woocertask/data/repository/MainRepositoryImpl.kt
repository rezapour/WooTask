package com.rezapour.woocertask.data.repository

import com.rezapour.woocertask.data.network.ApiProvider
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow
import javax.inject.Inject

class MainRepositoryImpl constructor(private val apiProvider: ApiProvider) : MainRepository {
    override fun getProducts()= flow {
        emit(1)
    }
}