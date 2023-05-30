package com.example.product_list.domain.interactor

import com.example.product_list.data.repository.ProductListRepository
import com.example.product_list.domain.model.ProductListModel

class ProductListInteractorImpl(
    private val repository: ProductListRepository
    ): ProductListInteractor {
    override suspend fun getProductList(): ProductListModel? {
        return repository.getProductList()
    }

}