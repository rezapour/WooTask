package com.rezapour.woocertask.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rezapour.woocertask.model.product.Categories

@Entity(tableName = "table_products")
class ProductCacheEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "slug") val slug: String,
    @ColumnInfo(name = "perma_link") val permalink: String,
    @ColumnInfo(name = "date_created_gmt") val dateCreatedGmt: String,
    @ColumnInfo(name = "date_modified_gmt") val dateModifiedGmt: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "featured") val featured: Boolean,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "short_description") val shortDescription: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "regular_price") val regularPrice: String,
    @ColumnInfo(name = "sale_price") val salePrice: String,
    @ColumnInfo(name = "on_sale") val onSale: Boolean,
    @ColumnInfo(name = "purchasable") val purchasable: Boolean,
    @ColumnInfo(name = "total_sales") val totalSales: Int,
    @ColumnInfo(name = "tax_status") val taxStatus: String,
    @ColumnInfo(name = "stock_quantity") val stockQuantity: Int,
    @ColumnInfo(name = "backorders") val backorders: String,
    @ColumnInfo(name = "backorders_allowed") val backordersAllowed: Boolean,
    @ColumnInfo(name = "sold_individually") val soldIndividually: Boolean,
    @ColumnInfo(name = "shipping_required") val shippingRequired: Boolean,
    @ColumnInfo(name = "reviews_allowed") val reviewsAllowed: Boolean,
    @ColumnInfo(name = "average_rating") val averageRating: Double,
    @ColumnInfo(name = "rating_count") val ratingCount: Int,
//    @ColumnInfo(name = "categories") val categories: List<CategoriesCacheEntity>,
    @ColumnInfo(name = "images_url") val imagesUrl: String,
    @ColumnInfo(name = "stock_status") val stockStatus: String
)