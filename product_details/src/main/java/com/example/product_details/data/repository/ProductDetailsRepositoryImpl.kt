package com.example.product_details.data.repository

import com.example.product_details.data.api.ProductDetailsApi
import com.example.product_details.data.mapper.ProductDetailsMapper.map
import com.example.product_details.domain.model.ProductDetailsModel

class ProductDetailsRepositoryImpl (
    private val api: ProductDetailsApi
): ProductDetailsRepository {
    override suspend fun getProductDetails(): ProductDetailsModel{
        return api.getProductDetails().body()!!.map()
    }
}