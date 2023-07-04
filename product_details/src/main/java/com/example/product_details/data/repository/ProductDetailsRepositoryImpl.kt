package com.example.product_details.data.repository

import com.example.product_details.data.api.ProductDetailsApi
import com.example.product_details.data.mapper.ProductDetailsMapper.map
import com.example.product_details.domen.model.DetailsModel

class ProductDetailsRepositoryImpl (
    private val api: ProductDetailsApi
): ProductDetailsRepository {
    override suspend fun getProductDetails(): DetailsModel {
        return api.getProductDetails().body()!!.map()
    }
}