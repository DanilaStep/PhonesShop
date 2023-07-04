package com.example.mycart.data.mapper

import com.example.core.base.BaseMapper
import com.example.mycart.data.dto.BasketDto
import com.example.mycart.data.dto.responce.MyCartResponse
import com.example.mycart.domen.model.BasketModel
import com.example.mycart.domen.model.MyCartModel


object MyCartMapper : BaseMapper<MyCartResponse, MyCartModel> {
    override fun MyCartResponse.map(): MyCartModel {
        return MyCartModel(
            basket = mapBasket(this.basket),
            delivery = this.delivery,
            total = this.total,
            id = this.id
        )
    }

    private fun mapBasket(list: List<BasketDto>?): MutableList<BasketModel> =
        mutableListOf<BasketModel>().apply {
            list?.forEach {
                add(
                    BasketModel(
                        id = it.id,
                        image = it.images,
                        price = it.price,
                        title = it.title

                    )
                )
            }
        }
}
