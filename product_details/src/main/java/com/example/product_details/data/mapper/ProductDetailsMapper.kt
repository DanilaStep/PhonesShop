package com.example.product_details.data.mapper

import com.example.core.base.BaseMapper
import com.example.product_details.data.dto.ProductDetailsDto
import com.example.product_details.data.dto.response.ProductDetailsResponse
import com.example.product_details.domen.model.DetailsModel
import com.example.product_details.domain.model.ProductDetailsModel

object ProductDetailsMapper : BaseMapper<ProductDetailsResponse, ProductDetailsModel> {
    override fun ProductDetailsResponse.map(): ProductDetailsModel {
        return ProductDetailsModel(
            productDetail = mapProductDetails(this.product_detail)
        )
    }

    private fun mapProductDetails(list: List<ProductDetailsDto>): MutableList<DetailsModel> =
        mutableListOf<DetailsModel>().apply {
            list.forEach {
                add(
                    DetailsModel(
                        CPU = it.CPU,
                        camera = it.camera,
                        capacity = it.capacity,
                        color = it.color,
                        id = it.id,
                        images = it.images,
                        isFavorites = it.isFavorites,
                        price = it.price,
                        rating = it.rating,
                        sd = it.sd,
                        ssd = it.ssd,
                        title = it.title
                    )
                )

            }
        }
}