package com.example.product_list.di

import com.example.core.retrofit.RetrofitFactory
import com.example.product_list.data.api.ProductListApi
import com.example.product_list.data.repository.ProductListRepository
import com.example.product_list.data.repository.ProductListRepositoryIml
import com.example.product_list.domain.interactor.ProductListInteractor
import com.example.product_list.domain.interactor.ProductListInteractorImpl
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class ProductListModule {

    @Single
    fun provideApi(retrofit: RetrofitFactory): ProductListApi =
        retrofit.getApiInterface(ProductListApi::class.java)

    @Single
    fun provideRepository(api: ProductListApi): ProductListRepository =
        ProductListRepositoryIml(api)

    @Single
    fun provideInteractor(repository: ProductListRepository): ProductListInteractor =
        ProductListInteractorImpl(repository)

}