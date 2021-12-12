package com.rezapour.woocertask.data.database

import com.rezapour.woocertask.data.database.entities.ProductCacheEntity
import com.rezapour.woocertask.model.product.Product
import com.rezapour.woocertask.util.EntityMapper
import javax.inject.Inject

class CacheMapper @Inject constructor() : EntityMapper<ProductCacheEntity, Product> {
    override fun mapFromEntity(entity: ProductCacheEntity): Product {
        return Product(
            id = entity.id,
            name = entity.name,
            slug = entity.slug,
            permalink = entity.permalink,
            dateCreatedGmt = entity.dateCreatedGmt,
            dateModifiedGmt = entity.dateModifiedGmt,
            type = entity.type,
            status = entity.status,
            featured = entity.featured,
            description = entity.description,
            shortDescription = entity.shortDescription,
            price = entity.price,
            regularPrice = entity.regularPrice,
            salePrice = entity.salePrice,
            onSale = entity.onSale,
            purchasable = entity.purchasable,
            totalSales = entity.totalSales,
            taxStatus = entity.taxStatus,
            stockQuantity = entity.stockQuantity,
            backorders = entity.backorders,
            backordersAllowed = entity.backordersAllowed,
            soldIndividually = entity.soldIndividually,
            shippingRequired = entity.shippingRequired,
            reviewsAllowed = entity.reviewsAllowed,
            averageRating = entity.averageRating,
            ratingCount = entity.ratingCount,
            stockStatus = entity.stockStatus,
            imagesUrl = entity.imagesUrl
        )
    }

    override fun mapToEntity(domailModel: Product): ProductCacheEntity {
        return ProductCacheEntity(
            id = domailModel.id,
            name = domailModel.name,
            slug = domailModel.slug,
            permalink = domailModel.permalink,
            dateCreatedGmt = domailModel.dateCreatedGmt,
            dateModifiedGmt = domailModel.dateModifiedGmt,
            type = domailModel.type,
            status = domailModel.status,
            featured = domailModel.featured,
            description = domailModel.description,
            shortDescription = domailModel.shortDescription,
            price = domailModel.price,
            regularPrice = domailModel.regularPrice,
            salePrice = domailModel.salePrice,
            onSale = domailModel.onSale,
            purchasable = domailModel.purchasable,
            totalSales = domailModel.totalSales,
            taxStatus = domailModel.taxStatus,
            stockQuantity = domailModel.stockQuantity,
            backorders = domailModel.backorders,
            backordersAllowed = domailModel.backordersAllowed,
            soldIndividually = domailModel.soldIndividually,
            shippingRequired = domailModel.shippingRequired,
            reviewsAllowed = domailModel.reviewsAllowed,
            averageRating = domailModel.averageRating,
            ratingCount = domailModel.ratingCount,
            stockStatus = domailModel.stockStatus,
            imagesUrl = domailModel.imagesUrl
        )
    }

    fun mapFromListEntity(entitys: List<ProductCacheEntity>): List<Product> {
        return entitys.map { mapFromEntity(it) }
    }


    fun mapToEntityList(domailModels: List<Product>): List<ProductCacheEntity> {
        return domailModels.map { mapToEntity(it) }
    }

}