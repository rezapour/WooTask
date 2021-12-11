package com.rezapour.woocertask.data.network.model

import com.google.gson.annotations.SerializedName

data class LinksNetworkEntity (
	@SerializedName("self") val self : List<SelfNetworkEntity>,
	@SerializedName("collection") val collection : List<CollectionNetworkEntity>
)