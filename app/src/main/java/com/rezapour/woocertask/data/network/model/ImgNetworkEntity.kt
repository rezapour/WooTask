package com.rezapour.woocertask.data.network.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class ImgNetworkEntity (

	@Expose @SerializedName("alt_text") val alt_text : String,
	@Expose @SerializedName("src") val src : String,
	@Expose @SerializedName("width") val width : Int,
	@Expose @SerializedName("height") val height : Int
)