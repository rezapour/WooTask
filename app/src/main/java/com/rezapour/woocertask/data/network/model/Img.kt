package com.rezapour.woocertask.data.network.model
import com.google.gson.annotations.SerializedName
data class Img (

	@SerializedName("alt_text") val alt_text : String,
	@SerializedName("src") val src : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int
)