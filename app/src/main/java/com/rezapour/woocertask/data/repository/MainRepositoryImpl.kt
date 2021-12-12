package com.rezapour.woocertask.data.repository

import android.util.Log
import com.rezapour.woocertask.asset.Constants
import com.rezapour.woocertask.data.database.CacheMapper
import com.rezapour.woocertask.data.database.dao.ProductDao
import com.rezapour.woocertask.data.network.ApiProvider
import com.rezapour.woocertask.data.network.NetworkMapper
import com.rezapour.woocertask.model.product.Product
import com.rezapour.woocertask.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepositoryImpl constructor(
    private val apiProvider: ApiProvider,
    private val dao: ProductDao,
    private val networkMapper: NetworkMapper,
    private val cacheMapper: CacheMapper
) : MainRepository {
    override suspend fun getProducts(): Flow<DataState<List<Product>>> = flow {
        emit(DataState.Loading)
        try {
            val response = apiProvider.getProducts(Constants.Ck, Constants.CS)
            when (response.code()) {
                200 -> {
                    val body = response.body()
                    if (body != null && body.isNotEmpty()) {
                        val products = networkMapper.mapFromListEntity(body)
                        for (product in products) {
                            dao.insertProduct(cacheMapper.mapToEntity(product))
                        }
                        val cacheProduct = dao.getProducts()
                        emit(DataState.Success(cacheMapper.mapFromListEntity(cacheProduct)))
                    } else {

                        val cacheProduct = dao.getProducts()
                        if (cacheProduct.isNotEmpty())
                            emit(DataState.Success(cacheMapper.mapFromListEntity(cacheProduct)))
                        else
                            emit(DataState.Error("null"))
                    }
                }
                else -> {
                    val cacheProduct = dao.getProducts()
                    if (cacheProduct.isNotEmpty())
                        emit(DataState.Success(cacheMapper.mapFromListEntity(cacheProduct)))
                    else
                        emit(DataState.Error("null1"))
                }
            }
        } catch (e: Exception) {
            val cacheProduct = dao.getProducts()
            if (cacheProduct.isNotEmpty())
                emit(DataState.Success(cacheMapper.mapFromListEntity(cacheProduct)))
            else
                emit(DataState.Error("null2"))

        }

    }


}