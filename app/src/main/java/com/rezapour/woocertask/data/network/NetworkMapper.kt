package com.rezapour.woocertask.data.network

import com.rezapour.woocertask.data.network.model.CategoriesNetworkEntity
import com.rezapour.woocertask.data.network.model.ImagesNetworkEntity
import com.rezapour.woocertask.data.network.model.LinksNetworkEntity
import com.rezapour.woocertask.data.network.model.ProductNetworkEntity
import com.rezapour.woocertask.model.product.*
import com.rezapour.woocertask.util.EntityMapper

class NetworkMapper : EntityMapper<ProductNetworkEntity, Product> {
    override fun mapFromEntity(entity: ProductNetworkEntity): Product {
        return Product(
            id = entity.id,
            name = entity.name,
            slug = entity.slug,
            permalink = entity.permalink,
            dateCreated = entity.dateCreated,
            dateCreatedGmt = entity.dateCreatedGmt,
            dateModified = entity.dateModified,
            dateModifiedGmt = entity.dateModifiedGmt,
            type = entity.type,
            status = entity.status,
            featured = entity.featured,
            catalogVisibility = entity.catalogVisibility,
            description = entity.description,
            shortDescription = entity.shortDescription,
            sku = entity.sku,
            price = entity.price,
            regularPrice = entity.regularPrice,
            salePrice = entity.salePrice,
            dateOnSaleFrom = entity.dateOnSaleFrom,
            dateOnSaleToGmt = entity.dateOnSaleToGmt,
            dateOnSaleTo = entity.dateOnSaleTo,
            dateOnSaleFromGmt = entity.dateOnSaleFromGmt,
            onSale = entity.onSale,
            purchasable = entity.purchasable,
            totalSales = entity.totalSales,
            virtual = entity.virtual,
            downloadable = entity.downloadable,
            downloads = entity.downloads,
            downloadLimit = entity.downloadLimit,
            downloadExpiry = entity.downloadExpiry,
            externalUrl = entity.externalUrl,
            buttonText = entity.buttonText,
            taxStatus = entity.taxStatus,
            taxClass = entity.taxClass,
            manageStock = entity.manageStock,
            stockQuantity = entity.stockQuantity,
            backorders = entity.backorders,
            backordersAllowed = entity.backordersAllowed,
            backordered = entity.backordered,
            soldIndividually = entity.soldIndividually,
            weight = entity.weight,
            dimensions = Dimensions(
                length = entity.dimensions.length,
                width = entity.dimensions.width,
                height = entity.dimensions.height
            ),
            shippingRequired = entity.shippingRequired,
            shippingTaxable = entity.shippingTaxable,
            shippingClass = entity.shippingClass,
            shippingClassId = entity.shippingClassId,
            reviewsAllowed = entity.reviewsAllowed,
            averageRating = entity.averageRating,
            ratingCount = entity.ratingCount,
            upsellIds = entity.upsellIds,
            crossSellIds = entity.crossSellIds,
            parentId = entity.parentId,
            purchaseNote = entity.purchaseNote,
            categories = MapFromCategoriesEntity(entity.categories),
            tags = entity.tags,
            images = mapFromImagesEntity(entity.images),
            attributes = entity.attributes,
            defaultAttributes = entity.defaultAttributes,
            variations = entity.variations,
            groupedProducts = entity.groupedProducts,
            menuOrder = entity.menuOrder,
            priceHtml = entity.priceHtml,
            stockStatus = entity.stockStatus,
            links = mapFromLinksEntity(entity.Links)

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

    private fun mapFromLinksEntity(linksEntity: LinksNetworkEntity): Links {
        return Links(
            self = linksEntity.self.map { Self(it.href) },
            collection = linksEntity.collection.map { Collection(it.href) }
        )
    }

    private fun mapFromImagesEntity(imagesEntity: List<ImagesNetworkEntity>): List<Images> {
        return imagesEntity.map { Images(
            id = it.id,
            dateCreated = it.dateCreated,
            dateModifiedGmt = it.dateModifiedGmt,
            dateCreatedGmt = it.dateCreatedGmt,
            dateModified = it.dateModified,
            src = it.src,
            name=it.name,
            alt=it.alt
        ) }
    }
}