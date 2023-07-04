package com.example.mycart.di

import com.example.core.retrofit.RetrofitFactory
import com.example.mycart.data.api.MyCartApi
import com.example.mycart.data.repository.MyCartRepository
import com.example.mycart.data.repository.MyCartRepositoryImpl
import com.example.mycart.domen.interactor.MyCartInteractor
import com.example.mycart.domen.interactor.MyCartInteractorImpl
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class MyCartModule {
    @Single
    fun provideApi(retrofit: RetrofitFactory): MyCartApi =
        retrofit.getApiInterface(MyCartApi::class.java)

    @Single
    fun provideRepository(api: MyCartApi): MyCartRepository =
        MyCartRepositoryImpl(api)

    @Single
    fun provideInteractor(repository: MyCartRepository): MyCartInteractor =
        MyCartInteractorImpl(repository)
}