package com.rezapour.woocertask.data.network.retrofit

import com.rezapour.woocertask.data.network.model.ProductNetworkEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET()
    suspend fun getProducts(
        @Url url:String,
        @Query("consumer_key") consumerKey: String,
        @Query("consumer_secret") consumerSecret: String
    ): Response<List<ProductNetworkEntity>>
}