package com.rezapour.woocertask.data.network.model

import com.google.gson.annotations.SerializedName
data class Categories (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("slug") val slug : String
)