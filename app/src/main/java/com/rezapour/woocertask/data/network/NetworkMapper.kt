package com.rezapour.woocertask.data.network

import com.rezapour.woocertask.data.network.model.CategoriesNetworkEntity
import com.rezapour.woocertask.data.network.model.ImagesNetworkEntity
import com.rezapour.woocertask.data.network.model.LinksNetworkEntity
import com.rezapour.woocertask.data.network.model.ProductNetworkEntity
import com.rezapour.woocertask.model.product.*
import com.rezapour.woocertask.util.EntityMapper
import javax.inject.Inject

class NetworkMapper @Inject constructor() {
    fun mapFromEntity(entity: ProductNetworkEntity): Product {
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
//            categories = MapFromCategoriesEntity(entity.categories),
            stockStatus = entity.stockStatus,
            imagesUrl = entity.images.get(0).src

        )
    }

    private fun MapFromCategoriesEntity(categoryEntityList: List<CategoriesNetworkEntity>): List<Categories> {
        return categoryEntityList.map {
            Categories(
                id = it.id,
                name = it.name,
                slug = it.slug
            )
        }
    }

}