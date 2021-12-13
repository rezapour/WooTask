package com.rezapour.woocertask.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rezapour.woocertask.data.database.entities.ProductCacheEntity
import com.rezapour.woocertask.data.database.entities.UserCacheEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: ProductCacheEntity): Long

    @Query("Select * From table_products")
    suspend fun getProducts(): List<ProductCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserCacheEntity): Long

    @Query("Select * From table_user where id=1")
    suspend fun getUser(): UserCacheEntity


}