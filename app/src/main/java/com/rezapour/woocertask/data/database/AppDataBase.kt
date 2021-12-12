package com.rezapour.woocertask.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rezapour.woocertask.data.database.dao.ProductDao
import com.rezapour.woocertask.data.database.entities.ProductCacheEntity


@Database(entities = [ProductCacheEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}