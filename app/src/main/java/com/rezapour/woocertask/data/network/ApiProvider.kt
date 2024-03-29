package com.rezapour.woocertask.data.network

import com.rezapour.woocertask.data.network.model.ProductNetworkEntity
import retrofit2.Response

interface ApiProvider {
    suspend fun getProducts(
        url:String,
        consumerKey: String,
        consumerSecret: String
    ): Response<List<ProductNetworkEntity>>

}