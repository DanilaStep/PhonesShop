package com.example.product_list.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.core.base.BaseProductAdapter
import com.example.product_list.R
import com.example.product_list.databinding.ItemBestSellerBinding
import com.example.product_list.domain.model.BestSellerModel

class BestSellerAdapter(private val listener: ClickListener):
    BaseProductAdapter<BestSellerModel, ItemBestSellerBinding>(DiffUtilCallback) {
    object DiffUtilCallback: DiffUtil.ItemCallback<BestSellerModel>(){
        override fun areItemsTheSame(
            oldItem: BestSellerModel, newItem: BestSellerModel
        )= oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: BestSellerModel,
            newItem: BestSellerModel
        ) = oldItem == newItem
        }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        viewType: Int
    ): ItemBestSellerBinding {
       return  ItemBestSellerBinding.inflate(inflater, container, false)
    }

    override fun bindViewHolder(holder: ViewHolder, data: BestSellerModel) {
        with(holder.binding){
            val placeholder = ResourcesCompat.getDrawable(root.resources, R.drawable.ic_load, null)
            Glide.with(ivPhone1)
                .load(data.picture)
                .placeholder(placeholder)
                .error(R.drawable.ic_funnel)
                .into(ivPhone1)
            tvPrice.text = data.priceWithoutDiscount.toString()
            tvOldPrice.text = data.discountPrice.toString()
            tvNamePhone.text = data.title
            val isFavoritesResource = if (data.isFavorites) {
                R.drawable.ic_like_fill
            } else {
                R.drawable.ic_like_stroke
            }
            ivLike.setImageResource(isFavoritesResource)
            llBastSeller.setOnClickListener {
                listener.onClickBestSeller(data.id)
            }
            cvLike.setOnClickListener{
                listener.onClickLike(data.id)
            }
        }
    }
    interface ClickListener{
        fun onClickBestSeller(id: Int)
        fun onClickLike(id: Int)
    }
}