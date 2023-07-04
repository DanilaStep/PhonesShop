package com.example.product_details.domain.interactor

import com.example.product_details.domen.model.DetailsModel

interface ProductDetailsInteractor {
    suspend fun getProductDetails(): DetailsModel
}