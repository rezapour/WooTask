package com.rezapour.woocertask.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rezapour.woocertask.data.database.entities.ProductCacheEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: ProductCacheEntity): Long

    @Query("Select * From table_products")
    suspend fun getProducts(): List<ProductCacheEntity>

}