package com.example.mycart.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.core.base.BaseProductAdapter
import com.example.mycart.databinding.ItemMyCartBinding
import com.example.mycart.domen.model.BasketModel

class MyCartAdapter(private val listener: ClickListener) :
    BaseProductAdapter<BasketModel, ItemMyCartBinding>(DiffUtilCallback) {
    object DiffUtilCallback : DiffUtil.ItemCallback<BasketModel>() {
        override fun areItemsTheSame(
            oldItem: BasketModel, newItem: BasketModel
        ) = oldItem.id == newItem.id


        override fun areContentsTheSame(
            oldItem: BasketModel,
            newItem: BasketModel
        ) = oldItem == newItem
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        viewType: Int
    ): ItemMyCartBinding {
        return ItemMyCartBinding.inflate(inflater, container, false)
    }

    override fun bindViewHolder(holder: ViewHolder, data: BasketModel) {
        with(holder.binding) {
            Glide.with(ivModel)
                .load(data.image)
                .into(ivModel)
            tvModel.text = data.title
            tvPriceModel.text = data.price
            ivGarbage.setOnClickListener {
                listener.onClickDelete(data.id)
            }
        }

    }


    interface ClickListener {
        fun onClickDelete(id: Int)
    }
}