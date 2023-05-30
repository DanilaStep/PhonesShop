package com.example.product_list.data.api

import com.example.product_list.data.dto.response.ProductListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductListApi {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getProductList(): Response<ProductListResponse?>
}