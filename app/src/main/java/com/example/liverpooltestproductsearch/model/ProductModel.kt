package com.example.liverpooltestproductsearch.model

data class ProductModel(
    val productId: String,
    val skuRepositoryId: String,
    val productDisplayName: String,
    val productType: String,
    val productRatingCount: Long,
    val productAvgRating: Double,
    val promotionalGiftMessage: String,
    val listPrice: Double,
    val minimumListPrice: Double,
    val maximumListPrice: Double,
    val promoPrice: Double,
    val minimumPromoPrice: Double,
    val maximumPromoPrice: Double,
    val isHybrid: Boolean,
    val isMarketPlace: Boolean,
    val isImportationProduct: Boolean,
    val brand: String,
    val seller: String,
    val category: String,
    val isExpressFavoriteStore: Boolean,
    val isExpressNearByStore: Boolean,
    val smImage: String,
    val lgImage: String,
    val xlImage: String,
    val groupType: String,
    val plpFlags: List<PlpFlag>,
    val variantsColor: List<VariantsColor> = emptyList()
) {
    class Builder {
        private var productId: String = ""
        private var skuRepositoryId: String = ""
        private var productDisplayName: String = ""
        private var productType: String = ""
        private var productRatingCount: Long = 0
        private var productAvgRating: Double = 0.0
        private var promotionalGiftMessage: String = ""
        private var listPrice: Double = 0.0
        private var minimumListPrice: Double = 0.0
        private var maximumListPrice: Double = 0.0
        private var promoPrice: Double = 0.0
        private var minimumPromoPrice: Double = 0.0
        private var maximumPromoPrice: Double = 0.0
        private var isHybrid: Boolean = false
        private var isMarketPlace: Boolean = false
        private var isImportationProduct: Boolean = false
        private var brand: String = ""
        private var seller: String = ""
        private var category: String = ""
        private var isExpressFavoriteStore: Boolean = false
        private var isExpressNearByStore: Boolean = false
        private var smImage: String = ""
        private var lgImage: String = ""
        private var xlImage: String = ""
        private var groupType: String = ""
        private var plpFlags: List<PlpFlag> = emptyList()
        private var variantsColor: List<VariantsColor> = emptyList()

        fun productId(productId: String) = apply { this.productId = productId }
        fun skuRepositoryId(skuRepositoryId: String) = apply { this.skuRepositoryId = skuRepositoryId }
        fun productDisplayName(productDisplayName: String) = apply { this.productDisplayName = productDisplayName }
        fun productType(productType: String) = apply { this.productType = productType }
        fun productRatingCount(productRatingCount: Long) = apply { this.productRatingCount = productRatingCount }
        fun productAvgRating(productAvgRating: Double) = apply { this.productAvgRating = productAvgRating }
        fun promotionalGiftMessage(promotionalGiftMessage: String) = apply { this.promotionalGiftMessage = promotionalGiftMessage }
        fun listPrice(listPrice: Double) = apply { this.listPrice = listPrice }
        fun minimumListPrice(minimumListPrice: Double) = apply { this.minimumListPrice = minimumListPrice }
        fun maximumListPrice(maximumListPrice: Double) = apply { this.maximumListPrice = maximumListPrice }
        fun promoPrice(promoPrice: Double) = apply { this.promoPrice = promoPrice }
        fun minimumPromoPrice(minimumPromoPrice: Double) = apply { this.minimumPromoPrice = minimumPromoPrice }
        fun maximumPromoPrice(maximumPromoPrice: Double) = apply { this.maximumPromoPrice = maximumPromoPrice }
        fun isHybrid(isHybrid: Boolean) = apply { this.isHybrid = isHybrid }
        fun isMarketPlace(isMarketPlace: Boolean) = apply { this.isMarketPlace = isMarketPlace }
        fun isImportationProduct(isImportationProduct: Boolean) = apply { this.isImportationProduct = isImportationProduct }
        fun brand(brand: String) = apply { this.brand = brand }
        fun seller(seller: String) = apply { this.seller = seller }
        fun category(category: String) = apply { this.category = category }
        fun isExpressFavoriteStore(isExpressFavoriteStore: Boolean) = apply { this.isExpressFavoriteStore = isExpressFavoriteStore }
        fun isExpressNearByStore(isExpressNearByStore: Boolean) = apply { this.isExpressNearByStore = isExpressNearByStore }
        fun smImage(smImage: String) = apply { this.smImage = smImage }
        fun lgImage(lgImage: String) = apply { this.lgImage = lgImage }
        fun xlImage(xlImage: String) = apply { this.xlImage = xlImage }
        fun groupType(groupType: String) = apply { this.groupType = groupType }
        fun plpFlags(plpFlags: List<PlpFlag>) = apply { this.plpFlags = plpFlags }
        fun variantsColor(variantsColor: List<VariantsColor>) = apply { this.variantsColor = variantsColor }

        fun build(): ProductModel {
            return ProductModel(
                productId,
                skuRepositoryId,
                productDisplayName,
                productType,
                productRatingCount,
                productAvgRating,
                promotionalGiftMessage,
                listPrice,
                minimumListPrice,
                maximumListPrice,
                promoPrice,
                minimumPromoPrice,
                maximumPromoPrice,
                isHybrid,
                isMarketPlace,
                isImportationProduct,
                brand,
                seller,
                category,
                isExpressFavoriteStore,
                isExpressNearByStore,
                smImage,
                lgImage,
                xlImage,
                groupType,
                plpFlags,
                variantsColor
            )
        }
    }
}


data class DwPromotionInfo(
    val dwToolTipInfo: String,
    val dWpromoDescription: String,
)

data class PlpFlag(
    val flagId: String,
    val flagMessage: String,
)

data class VariantsColor(
    val colorName: String,
    val colorHex: String,
    val colorImageUrl: String,
    val colorMainUrl: Any?,
    val skuId: Any?,
    val galleryImages: Any?,
)