package com.example.product_list.data.repository

import com.example.product_list.domain.model.ProductListModel

interface ProductListRepository {
    suspend fun getProductList(): ProductListModel?
}