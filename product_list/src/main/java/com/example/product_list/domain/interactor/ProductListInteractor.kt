package com.example.product_list.domain.interactor

import com.example.product_list.domain.model.ProductListModel

interface ProductListInteractor {
    suspend fun getProductList(): ProductListModel?
}