package com.example.mycart.data.api

import com.example.mycart.data.dto.responce.MyCartResponse
import retrofit2.Response
import retrofit2.http.GET

interface MyCartApi {
    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getMyCart(): Response<MyCartResponse?>
}