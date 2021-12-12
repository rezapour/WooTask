package com.rezapour.woocertask.data.network.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class ImagesNetworkEntity (

	@Expose @SerializedName("id") val id : Int,
	@Expose @SerializedName("date_created") val dateCreated : String,
	@Expose @SerializedName("date_created_gmt") val dateCreatedGmt : String,
	@Expose @SerializedName("date_modified") val dateModified : String,
	@Expose @SerializedName("date_modified_gmt") val dateModifiedGmt : String,
	@Expose @SerializedName("src") val src : String,
	@Expose @SerializedName("name") val name : String,
	@Expose @SerializedName("alt") val alt : String
)