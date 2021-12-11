package com.rezapour.woocertask.model.product

import com.google.gson.annotations.SerializedName

data class Images(
    val id: Int,
    val dateCreated: String,
    val dateCreatedGmt: String,
    val dateModified: String,
    val dateModifiedGmt: String,
    val src: String,
    val name: String,
    val alt: String
)