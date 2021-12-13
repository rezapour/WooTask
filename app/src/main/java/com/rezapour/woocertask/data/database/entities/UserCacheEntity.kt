package com.rezapour.woocertask.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_user")
class UserCacheEntity(
    @PrimaryKey val id: Int = 1,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "webSite") val webSite: String,
    @ColumnInfo(name = "consumer_key") val consumerKey: String,
    @ColumnInfo(name = "consumer_secret") val consumerSecret: String
)
