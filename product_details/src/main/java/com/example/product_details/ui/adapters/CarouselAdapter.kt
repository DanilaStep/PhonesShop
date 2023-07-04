package com.example.product_details.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.core.base.BaseProductAdapter
import com.example.product_details.databinding.ItemCaruselDetailsModelBinding

class CarouselAdapter() :
    BaseProductAdapter<String, ItemCaruselDetailsModelBinding>(DiffUtilCallback) {
    object DiffUtilCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String, newItem: String
        ) = oldItem.length == newItem.length

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ) = oldItem == newItem
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        viewType: Int
    ): ItemCaruselDetailsModelBinding {
        return ItemCaruselDetailsModelBinding.inflate(inflater, container, false)
    }

    override fun bindViewHolder(holder: ViewHolder, data: String) {
        with(holder.binding) {
            Glide.with(ivCarusel)
                .load(data)
                .into(ivCarusel)
        }
    }
}

