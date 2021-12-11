package com.rezapour.woocertask.data.repository

import com.rezapour.woocertask.data.network.model.ProductNetworkEntity
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

interface MainRepository {

    fun getProducts()= flow<Int>{

    }
}