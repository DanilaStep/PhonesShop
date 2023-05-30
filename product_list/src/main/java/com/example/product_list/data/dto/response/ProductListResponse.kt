package com.example.product_list.data.dto.response

import com.example.product_list.data.dto.BestSellerDto
import com.example.product_list.data.dto.HomeStoreDto

data class ProductListResponse(
    val home_store: List<HomeStoreDto>,
    val best_seller: List<BestSellerDto>
)