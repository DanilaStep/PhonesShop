package com.example.product_details.data.repository

import com.example.product_details.domain.model.ProductDetailsModel

interface ProductDetailsRepository {
    suspend fun getProductDetails(): ProductDetailsModel
}