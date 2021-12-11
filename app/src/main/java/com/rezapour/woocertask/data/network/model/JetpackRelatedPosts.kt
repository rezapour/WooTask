package com.rezapour.woocertask.data.network.model
import com.google.gson.annotations.SerializedName
data class JetpackRelatedPosts (

	@SerializedName("id") val id : Int,
	@SerializedName("url") val url : String,
	@SerializedName("url_meta") val url_meta : UrlMeta,
	@SerializedName("title") val title : String,
	@SerializedName("date") val date : String,
	@SerializedName("format") val format : Boolean,
	@SerializedName("excerpt") val excerpt : String,
	@SerializedName("rel") val rel : String,
	@SerializedName("context") val context : String,
	@SerializedName("img") val img : Img,
	@SerializedName("classes") val classes : List<String>
)