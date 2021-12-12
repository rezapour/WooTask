package com.rezapour.woocertask.data.network.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
data class CollectionNetworkEntity (

	@Expose @SerializedName("href") val href : String
)