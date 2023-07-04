package com.example.product_details.domain.interactor

import com.example.product_details.data.repository.ProductDetailsRepository
import com.example.product_details.domen.model.DetailsModel

class ProductDetailsInteractorImpl(
    private val repository: ProductDetailsRepository
): ProductDetailsInteractor {
    override suspend fun getProductDetails(): DetailsModel {
        return repository.getProductDetails()
    }
}