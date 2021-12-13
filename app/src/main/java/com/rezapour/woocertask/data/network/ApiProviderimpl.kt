package com.rezapour.woocertask.data.network

import com.rezapour.woocertask.data.network.model.ProductNetworkEntity
import com.rezapour.woocertask.data.network.retrofit.ApiService
import retrofit2.Response
import javax.inject.Inject

class ApiProviderimpl @Inject constructor(private val apiService: ApiService) : ApiProvider {
    override suspend fun getProducts(
        url:String,
        consumerKey: String,
        consumerSecret: String
    ): Response<List<ProductNetworkEntity>> {
        return apiService.getProducts(url,consumerKey, consumerSecret)
    }
}