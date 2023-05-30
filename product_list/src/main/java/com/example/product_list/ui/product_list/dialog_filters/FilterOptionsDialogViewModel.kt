package com.example.product_list.ui.product_list.dialog_filters

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
class FilterOptionsDialogViewModel(private val interactor: ProductListInteractor): ViewModel() {
private val _filterStateFlow = MutableStateFlow<ProductListModel?>(null)
val filterStateFlow : StateFlow<ProductListModel?> = _filterStateFlow
    .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

init {
    getAllProducts()
}
    fun getAllProducts(){
        viewModelScope.launch {
            _filterStateFlow.value = interactor.getProductList()
        }
    }
}