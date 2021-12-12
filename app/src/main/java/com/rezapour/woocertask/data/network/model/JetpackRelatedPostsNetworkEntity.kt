package com.rezapour.woocertask.data.network.model
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class JetpackRelatedPostsNetworkEntity (

    @Expose @SerializedName("id") val id : Int,
    @Expose @SerializedName("url") val url : String,
    @Expose @SerializedName("url_meta") val urlMeta : UrlMetaNetworkEntity,
    @Expose @SerializedName("title") val title : String,
    @Expose @SerializedName("date") val date : String,
    @Expose @SerializedName("format") val format : Boolean,
    @Expose @SerializedName("excerpt") val excerpt : String,
    @Expose @SerializedName("rel") val rel : String,
    @Expose @SerializedName("context") val context : String,
    @Expose @SerializedName("img") val img: ImgNetworkEntity,
    @Expose @SerializedName("classes") val classes : List<String>
)