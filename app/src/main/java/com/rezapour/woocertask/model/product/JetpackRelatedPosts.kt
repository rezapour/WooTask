package com.rezapour.woocertask.model.product

data class JetpackRelatedPosts (
    val id : Int,
    val url : String,
    val urlMeta : UrlMeta,
    val title : String,
    val date : String,
    val format : Boolean,
    val excerpt : String,
    val rel : String,
    val context : String,
    val img: Img,
    val classes : List<String>
)