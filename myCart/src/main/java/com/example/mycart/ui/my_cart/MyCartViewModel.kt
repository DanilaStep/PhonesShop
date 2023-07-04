package com.example.mycart.ui.my_cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycart.domen.interactor.MyCartInteractor
import com.example.mycart.domen.model.MyCartModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MyCartViewModel(private val interactor: MyCartInteractor) : ViewModel() {
    private val _myCartStateFlow = MutableStateFlow<MyCartModel?>(null)
    val myCartStateFlow: StateFlow<MyCartModel?> = _myCartStateFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    init {
        getAllMyCart()
    }

    fun getAllMyCart() {
        viewModelScope.launch {
            _myCartStateFlow.value = interactor.getMyCart()
        }

    }
}