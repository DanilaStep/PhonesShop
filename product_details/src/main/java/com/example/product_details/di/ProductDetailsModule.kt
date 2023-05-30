package com.example.product_details.di

import com.example.core.retrofit.RetrofitFactory
import com.example.product_details.data.api.ProductDetailsApi
import com.example.product_details.data.repository.ProductDetailsRepository
import com.example.product_details.data.repository.ProductDetailsRepositoryImpl
import com.example.product_details.domain.interactor.ProductDetailsInteractor
import com.example.product_details.domain.interactor.ProductDetailsInteractorImpl
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class ProductDetailsModule {

    @Single
    fun provideDetApi(retrofit: RetrofitFactory): ProductDetailsApi =
        retrofit.getApiInterface(ProductDetailsApi::class.java)

    @Single
    fun provideDetRepository(api: ProductDetailsApi): ProductDetailsRepository =
        ProductDetailsRepositoryImpl(api)

    @Single
    fun provideDetInteractor(repository: ProductDetailsRepository): ProductDetailsInteractor =
        ProductDetailsInteractorImpl(repository)
}