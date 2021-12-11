package com.rezapour.woocertask.data.network.model
import com.google.gson.annotations.SerializedName
data class ImagesNetworkEntity (

	@SerializedName("id") val id : Int,
	@SerializedName("date_created") val dateCreated : String,
	@SerializedName("date_created_gmt") val dateCreatedGmt : String,
	@SerializedName("date_modified") val dateModified : String,
	@SerializedName("date_modified_gmt") val dateModifiedGmt : String,
	@SerializedName("src") val src : String,
	@SerializedName("name") val name : String,
	@SerializedName("alt") val alt : String
)