package com.rezapour.woocertask.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DimensionsNetworkEntity (

	@Expose @SerializedName("length") val length : String,
	@Expose @SerializedName("width") val width : String,
	@Expose @SerializedName("height") val height : String
)