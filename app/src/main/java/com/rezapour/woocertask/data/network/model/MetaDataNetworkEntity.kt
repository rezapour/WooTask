package com.rezapour.woocertask.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MetaDataNetworkEntity(

    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("key") val key: String,

)