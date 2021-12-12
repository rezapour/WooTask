package com.rezapour.woocertask.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LinksNetworkEntity (
	@Expose @SerializedName("self") val self : List<SelfNetworkEntity>,
	@Expose @SerializedName("collection") val collection : List<CollectionNetworkEntity>
)