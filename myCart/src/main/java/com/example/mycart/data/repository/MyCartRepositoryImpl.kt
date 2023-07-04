package com.example.mycart.data.repository

import com.example.mycart.data.api.MyCartApi
import com.example.mycart.data.mapper.MyCartMapper.map
import com.example.mycart.domen.model.MyCartModel

class MyCartRepositoryImpl(
    private val api: MyCartApi
) : MyCartRepository {
    override suspend fun getMyCart(): MyCartModel {
        api.getMyCart()
        api.getMyCart().body()
        api.getMyCart().isSuccessful
        api.getMyCart().code()
        return api.getMyCart().body()!!.map()
    }

}