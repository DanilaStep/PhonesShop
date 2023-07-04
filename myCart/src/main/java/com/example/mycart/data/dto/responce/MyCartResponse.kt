package com.example.mycart.data.dto.responce

import com.example.mycart.data.dto.BasketDto

data class MyCartResponse(
    val basket: List<BasketDto>,
    val delivery: String,
    val id: String,
    val total: Int
)