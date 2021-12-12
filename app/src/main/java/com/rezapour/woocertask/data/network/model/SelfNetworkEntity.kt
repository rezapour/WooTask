package com.rezapour.woocertask.data.network.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class SelfNetworkEntity (
	@Expose @SerializedName("href") val href : String
)