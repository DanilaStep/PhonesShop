package com.example.product_list.data.repository

import com.example.product_list.data.api.ProductListApi
import com.example.product_list.data.mapper.ProductListMapper.map
import com.example.product_list.domain.model.ProductListModel

class ProductListRepositoryIml(
    private val api: ProductListApi
): ProductListRepository {

    override suspend fun getProductList(): ProductListModel? {
        api.getProductList()
        api.getProductList().body()
        api.getProductList().isSuccessful
        api.getProductList().code()
        return api.getProductList().body().map()
    }
}