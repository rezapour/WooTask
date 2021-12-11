package com.rezapour.woocertask.data.network.retrofit

import com.rezapour.woocertask.data.network.model.ProductNetworkEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("wp-json/wc/v3/products")
    suspend fun getProducts(
        @Query("consumer_key") consumerKey: String,
        @Query("consumer_secret") consumerSecret: String
    ): Response<List<ProductNetworkEntity>>
}