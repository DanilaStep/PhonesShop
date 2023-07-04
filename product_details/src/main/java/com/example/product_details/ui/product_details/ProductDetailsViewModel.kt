package com.example.product_details.ui.product_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.models.ScreenStateEnum
import com.example.core.models.ScreenStateEnum.*
import com.example.product_details.domain.interactor.ProductDetailsInteractor
import com.example.product_details.domen.model.DetailsModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ProductDetailsViewModel(private val interactor: ProductDetailsInteractor) : ViewModel() {
    private val _productDetailsStateFlow = MutableStateFlow<DetailsModel?>(null)
    val productDetailsStateFlow: StateFlow<DetailsModel?> = _productDetailsStateFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)
    private val _screenStateFlow = MutableStateFlow(PROGRESS)
    val screenStateFlow: StateFlow<ScreenStateEnum> = _screenStateFlow

    init {
        getAllProductDetails()
    }

    fun getAllProductDetails() {
        _screenStateFlow.value = PROGRESS
        viewModelScope.launch {
            try {
                _productDetailsStateFlow.value = interactor.getProductDetails()
                _screenStateFlow.value = SUCCESS
            } catch (e: Exception) {
                _productDetailsStateFlow.value = null
                _screenStateFlow.value = ERROR
            }
        }
    }
}