package com.example.product_list.domain.model

data class ProductListModel(
    val homeStore: List<HomeStoreModel>,
    val bestSeller: List<BestSellerModel>
) {
    companion object {
        val EMPTY = ProductListModel(emptyList(), emptyList())
    }
}