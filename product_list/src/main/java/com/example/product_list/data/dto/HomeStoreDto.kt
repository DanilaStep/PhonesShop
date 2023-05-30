package com.example.product_list.data.dto

data class HomeStoreDto(
    val id: Int,
    val is_new: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
)