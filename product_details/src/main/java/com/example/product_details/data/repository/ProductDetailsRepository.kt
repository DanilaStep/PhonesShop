package com.example.product_details.data.repository

import com.example.product_details.domen.model.DetailsModel

interface ProductDetailsRepository {
    suspend fun getProductDetails(): DetailsModel
}