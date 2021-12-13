package com.rezapour.woocertask.data.repository

import android.content.Context
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rezapour.woocertask.asset.Constants
import com.rezapour.woocertask.data.database.CacheMapper
import com.rezapour.woocertask.data.database.dao.ProductDao
import com.rezapour.woocertask.data.database.entities.UserCacheEntity
import com.rezapour.woocertask.data.googleDatabase.FireStoreDataBase
import com.rezapour.woocertask.data.network.ApiProvider
import com.rezapour.woocertask.data.network.NetworkMapper
import com.rezapour.woocertask.model.product.Product
import com.rezapour.woocertask.model.user.User
import com.rezapour.woocertask.util.DataState
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.lang.Exception


class MainRepositoryImpl constructor(
    private val apiProvider: ApiProvider,
    private val dao: ProductDao,
    private val networkMapper: NetworkMapper,
    private val cacheMapper: CacheMapper,
    private val fireStore: FireStoreDataBase
) : MainRepository {
    override suspend fun getProducts(): Flow<DataState<List<Product>>> = flow {
        emit(DataState.Loading)
        try {
            val user = dao.getUser()
            val url = user.webSite + Constants.SUB_DOMAIN
            val response = apiProvider.getProducts(url,user.consumerKey, user.consumerSecret)
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
                            emit(DataState.Error("There are no product to show please check your internet connection"))
                    }
                }
                401 -> {
                    val cacheProduct = dao.getProducts()
                    if (cacheProduct.isNotEmpty())
                        emit(DataState.Success(cacheMapper.mapFromListEntity(cacheProduct)))
                    else
                        emit(DataState.Error("the consumer_key or consumer_secret is wrong. "))
                }
                else -> {
                    val cacheProduct = dao.getProducts()
                    if (cacheProduct.isNotEmpty())
                        emit(DataState.Success(cacheMapper.mapFromListEntity(cacheProduct)))
                    else
                        emit(DataState.Error("There are no product to show please check your internet connection"))
                }
            }
        } catch (e: Exception) {
            val cacheProduct = dao.getProducts()
            if (cacheProduct.isNotEmpty()) {
                emit(DataState.Success(cacheMapper.mapFromListEntity(cacheProduct)))
            } else
                emit(DataState.Error("There are no product to show please check your internet connection"))

        }

    }

    override suspend fun saveUser(user: User): Flow<DataState<User>> = callbackFlow {
        fireStore.saveUser(user).collect {
            if (it.equals("done")) {
                dao.insertUser(cacheMapper.mapToEntity(user))
                trySend(DataState.Success(user))
            } else {
                trySend(DataState.Error("Something happened, login is not completed"))
            }

        }
        awaitClose { cancel() }
    }

    override fun getUser() = flow<UserCacheEntity> {
        emit(dao.getUser())
    }

}