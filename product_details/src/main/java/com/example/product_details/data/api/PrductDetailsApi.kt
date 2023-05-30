package com.example.product_details.data.api

import com.example.product_details.data.dto.response.ProductDetailsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductDetailsApi {
    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getProductDetails(): Response<ProductDetailsResponse>
}