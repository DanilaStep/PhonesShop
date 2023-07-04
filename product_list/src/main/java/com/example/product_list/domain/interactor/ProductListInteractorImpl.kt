package com.example.product_list.domain.interactor

import com.example.product_list.data.repository.ProductListRepository
import com.example.product_list.domain.model.ProductListModel
import kotlinx.coroutines.delay

class ProductListInteractorImpl(
    private val repository: ProductListRepository
    ): ProductListInteractor {
    override suspend fun getProductList(): ProductListModel? {
        delay(1000)
        return repository.getProductList()
    }

}