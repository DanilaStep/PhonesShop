package com.example.product_details.domain.interactor

import com.example.product_details.domain.model.ProductDetailsModel

interface ProductDetailsInteractor {
    suspend fun getProductDetails(): ProductDetailsModel
}