package com.rezapour.woocertask.data.repository

import com.rezapour.woocertask.data.network.model.ProductNetworkEntity
import com.rezapour.woocertask.model.product.Product
import com.rezapour.woocertask.model.user.User
import com.rezapour.woocertask.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface MainRepository {

    suspend fun getProducts(): Flow<DataState<List<Product>>>

    suspend fun saveUser(user: User): Flow<DataState<User>>
}