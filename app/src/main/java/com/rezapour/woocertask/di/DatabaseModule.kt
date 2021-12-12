package com.rezapour.woocertask.di

import android.content.Context
import androidx.room.Room
import com.rezapour.woocertask.asset.Constants
import com.rezapour.woocertask.data.database.AppDataBase
import com.rezapour.woocertask.data.database.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            Constants.DATA_BASE_NAME
        )
            .build()
    }

    @Singleton
    @Provides
    fun provideProductDao(appDataBase: AppDataBase): ProductDao {
        return appDataBase.productDao()
    }
}