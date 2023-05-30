package com.example.product_details.ui.product_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.product_details.domain.interactor.ProductDetailsInteractor
import com.example.product_details.domain.model.ProductDetailsModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ProductDetailsViewModel(private val interactor: ProductDetailsInteractor) : ViewModel() {
private val _productDetailsStateFlow = MutableStateFlow<ProductDetailsModel?>(null)
val productDetailsStateFlow: StateFlow<ProductDetailsModel?> = _productDetailsStateFlow
    .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)
init {
    getAllProductDetails()
}
    fun getAllProductDetails(){
        viewModelScope.launch {
            _productDetailsStateFlow.value = interactor.getProductDetails()
        }
    }
}