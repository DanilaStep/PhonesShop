package com.example.product_list.data.mapper

import com.example.core.base.BaseMapper
import com.example.product_list.data.dto.BestSellerDto
import com.example.product_list.data.dto.HomeStoreDto
import com.example.product_list.data.dto.response.ProductListResponse
import com.example.product_list.domain.model.BestSellerModel
import com.example.product_list.domain.model.HomeStoreModel
import com.example.product_list.domain.model.ProductListModel

object ProductListMapper : BaseMapper<ProductListResponse?, ProductListModel?> {

    override fun ProductListResponse?.map(): ProductListModel? {
        return this?.let {
            ProductListModel(
                homeStore = mapHomeStore(it.home_store),
                bestSeller = mapBestSeller(it.best_seller)
            )
        }
    }

    private fun mapBestSeller(list: List<BestSellerDto>?): MutableList<BestSellerModel> =
        mutableListOf<BestSellerModel>().apply {
            list?.forEach {
                add(
                    BestSellerModel(
                        id = it.id,
                        picture = it.picture,
                        title = it.title,
                        isFavorites = it.is_favorites,
                        priceWithoutDiscount = it.price_without_discount,
                        discountPrice = it.discount_price
                    )
                )
            }
        }

    private fun mapHomeStore(list: List<HomeStoreDto>?): List<HomeStoreModel> =
        mutableListOf<HomeStoreModel>().apply {
            list?.forEach {
                add(
                    HomeStoreModel(
                        id = it.id,
                        isNew = it.is_new,
                        title = it.title,
                        subtitle = it.subtitle,
                        picture = it.picture,
                        isBuy = it.is_buy
                    )
                )
            }
        }
}