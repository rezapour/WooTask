package com.rezapour.woocertask.model.product

data class Product (
	val id : Int,
	val name : String,
	val slug : String,
	val permalink : String,
	val dateCreatedGmt : String,
	val dateModifiedGmt : String,
	val type : String,
	val status : String,
	val featured : Boolean,
	val description : String,
	val shortDescription : String,
	val price : Int,
	val regularPrice : Int,
	val salePrice : String,
	val onSale : Boolean,
	val purchasable : Boolean,
	val totalSales : Int,
	val taxStatus : String,
	val stockQuantity : Int,
	val backorders : String,
	val backordersAllowed : Boolean,
	val soldIndividually : Boolean,
	val shippingRequired : Boolean,
	val reviewsAllowed : Boolean,
	val averageRating : Double,
	val ratingCount : Int,
	val categories : List<Categories>,
	val imagesUrl : String,
	val stockStatus : String
)