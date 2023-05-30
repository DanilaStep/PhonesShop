package com.example.product_list.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.core.base.BaseProductAdapter
import com.example.product_list.databinding.ItemHotSaleBinding
import com.example.product_list.domain.model.HomeStoreModel

class HotSaleAdapter(private val listener: ClickListener) :
    BaseProductAdapter<HomeStoreModel, ItemHotSaleBinding>(DiffUtilCallback) {

    object DiffUtilCallback : DiffUtil.ItemCallback<HomeStoreModel>() {

        override fun areItemsTheSame(
            oldItem: HomeStoreModel, newItem: HomeStoreModel
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: HomeStoreModel,
            newItem: HomeStoreModel
        ) = oldItem == newItem
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        viewType: Int
    ): ItemHotSaleBinding {
        return ItemHotSaleBinding.inflate(inflater, container, false)
    }

    override fun bindViewHolder(holder: ViewHolder, data: HomeStoreModel) {
        with(holder.binding) {
            Glide.with(ivModelVisio)
                .load(data.picture)
                .into(ivModelVisio)
            tvModel.text = data.title
            tvSuper.text = data.subtitle
            tvNew.isVisible = data.isNew

            llHotSale.setOnClickListener {
                listener.onClickHomeStore(data.id)
            }
        }
    }

    interface ClickListener {
        fun onClickHomeStore(id: Int)
    }
}