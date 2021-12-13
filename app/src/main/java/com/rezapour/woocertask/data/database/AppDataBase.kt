package com.rezapour.woocertask.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rezapour.woocertask.data.database.dao.ProductDao
import com.rezapour.woocertask.data.database.entities.ProductCacheEntity
import com.rezapour.woocertask.data.database.entities.UserCacheEntity


@Database(entities = [ProductCacheEntity::class,UserCacheEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}