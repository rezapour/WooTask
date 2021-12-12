package com.rezapour.woocertask.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UrlMetaNetworkEntity (

	@Expose @SerializedName("origin") val origin : Int,
	@Expose @SerializedName("position") val position : Int
)