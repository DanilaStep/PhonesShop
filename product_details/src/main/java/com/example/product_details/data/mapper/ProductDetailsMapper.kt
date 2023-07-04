package com.example.product_details.data.mapper

import com.example.core.base.BaseMapper
import com.example.product_details.data.dto.ProductDetailsDto
import com.example.product_details.domen.model.DetailsModel

object ProductDetailsMapper : BaseMapper<ProductDetailsDto, DetailsModel> {

    override fun ProductDetailsDto.map(): DetailsModel {
        return DetailsModel(
            CPU = this.CPU,
            camera = this.camera,
            capacity = this.capacity,
            color = this.color,
            id = this.id,
            images = this.images,
            isFavorites = this.isFavorites,
            price = this.price,
            rating = this.rating,
            sd = this.sd,
            ssd = this.ssd,
            title = this.title
        )
    }
}