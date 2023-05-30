package com.example.product_list.data.dto


data class BestSellerDto(
    val id: Int,
    val is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
)