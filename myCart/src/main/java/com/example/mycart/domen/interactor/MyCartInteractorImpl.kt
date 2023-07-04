package com.example.mycart.domen.interactor

import com.example.mycart.data.repository.MyCartRepository
import com.example.mycart.domen.model.MyCartModel

class MyCartInteractorImpl(
    private val repository: MyCartRepository
) : MyCartInteractor {
    override suspend fun getMyCart(): MyCartModel {
        return repository.getMyCart()
    }

}