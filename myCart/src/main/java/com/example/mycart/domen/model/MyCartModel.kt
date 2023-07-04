package com.example.mycart.domen.model

data class MyCartModel(
    val basket: List<BasketModel>,
    val delivery: String,
    val id: String,
    val total: Int
)