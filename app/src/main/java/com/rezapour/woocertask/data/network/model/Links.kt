package com.rezapour.woocertask.data.network.model

import com.google.gson.annotations.SerializedName

data class Links (
	@SerializedName("self") val self : List<Self>,
	@SerializedName("collection") val collection : List<Collection>
)