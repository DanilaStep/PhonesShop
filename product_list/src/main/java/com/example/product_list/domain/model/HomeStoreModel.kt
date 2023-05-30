package com.example.product_list.domain.model

data class HomeStoreModel(
    val id: Int,
    val isNew: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val isBuy: Boolean
)