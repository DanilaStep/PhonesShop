package com.example.mycart.domen.interactor

import com.example.mycart.domen.model.MyCartModel

interface MyCartInteractor {
    suspend fun getMyCart(): MyCartModel
}