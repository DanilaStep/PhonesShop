package com.example.product_details.ui.adapters

//class ProductDetailsAdapter(private val listener: ClickListener) :
//    BaseProductAdapter<DetailsModel, ItemProductDetailsBinding>(DiffUtilCallback) {
//
//    object DiffUtilCallback : DiffUtil.ItemCallback<DetailsModel>() {
//
//        override fun areItemsTheSame(
//            oldItem: DetailsModel,
//            newItem: DetailsModel
//        ) = oldItem.id == newItem.id
//
//        override fun areContentsTheSame(
//            oldItem: DetailsModel,
//            newItem: DetailsModel
//        ) = oldItem == newItem
//    }
//
//
//    override fun getBinding(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        viewType: Int
//    ): ItemProductDetailsBinding {
//        return ItemProductDetailsBinding.inflate(inflater, container, false)
//    }
//
//    override fun bindViewHolder(holder: ViewHolder, data: DetailsModel) {
//        with(holder.binding) {
//
//        }
//    }
//
//    interface ClickListener {
//        fun onClickModel(id: Int)
//    }
//}