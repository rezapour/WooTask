package com.rezapour.woocertask.data.network.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
data class CategoriesNetworkEntity (

	@Expose @SerializedName("id") val id : Int,
	@Expose @SerializedName("name") val name : String,
	@Expose @SerializedName("slug") val slug : String
)