package com.rezapour.woocertask.data.network.model

import com.google.gson.annotations.SerializedName

data class UrlMetaNetworkEntity (

	@SerializedName("origin") val origin : Int,
	@SerializedName("position") val position : Int
)