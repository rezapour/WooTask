package com.rezapour.woocertask.data.network.model

import com.google.gson.annotations.SerializedName
data class Dimensions (

	@SerializedName("length") val length : String,
	@SerializedName("width") val width : String,
	@SerializedName("height") val height : String
)