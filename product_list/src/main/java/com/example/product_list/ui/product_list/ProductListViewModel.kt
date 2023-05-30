package com.example.product_list.ui.product_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.product_list.domain.model.ProductListModel
import com.example.product_list.domain.interactor.ProductListInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ProductListViewModel(private val interactor: ProductListInteractor) : ViewModel() {

    private val _productsStateFlow = MutableStateFlow<ProductListModel?>(ProductListModel.EMPTY)
    val productsStatFlow: StateFlow<ProductListModel?> = _productsStateFlow

    init {
        getAllProducts()
    }

    fun getAllProducts() {
        viewModelScope.launch {
            _productsStateFlow.value = interactor.getProductList()
        }
    }
}