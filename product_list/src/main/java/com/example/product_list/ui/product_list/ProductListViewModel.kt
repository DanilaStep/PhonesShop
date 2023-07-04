package com.example.product_list.ui.product_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.models.ScreenStateEnum
import com.example.core.models.ScreenStateEnum.*
import com.example.product_list.domain.interactor.ProductListInteractor
import com.example.product_list.domain.model.ProductListModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ProductListViewModel(private val interactor: ProductListInteractor) : ViewModel() {

    private val _productsStateFlow = MutableStateFlow<ProductListModel?>(ProductListModel.EMPTY)
    val productsStatFlow: StateFlow<ProductListModel?> = _productsStateFlow

    private val _screenStateFlow = MutableStateFlow(PROGRESS)
    val screenStateFlow: StateFlow<ScreenStateEnum> = _screenStateFlow

    init {
        getAllProducts()
    }

    fun getAllProducts() {
        _screenStateFlow.value = PROGRESS
        viewModelScope.launch {
            try {
                _productsStateFlow.value = interactor.getProductList()
                _screenStateFlow.value = SUCCESS
            } catch (e: Exception) {
                _productsStateFlow.value = null
                _screenStateFlow.value = ERROR
            }
        }
    }
}