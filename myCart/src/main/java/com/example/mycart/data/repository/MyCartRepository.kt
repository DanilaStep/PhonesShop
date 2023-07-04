package com.example.mycart.data.repository

import com.example.mycart.domen.model.MyCartModel

interface MyCartRepository {
    suspend fun getMyCart(): MyCartModel
}