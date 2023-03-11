package ru.effectiv.mobile.ui.pages.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.effectiv.domain.model.product.Product
import ru.effectiv.domain.usecase.GetProductUseCase

class Page2ViewModel(private val getProductUseCase: GetProductUseCase) : ViewModel() {
    private val _product = MutableLiveData<Product>().apply {
        viewModelScope.launch {
            value = getProductUseCase.execute()
        }
    }
    val product: MutableLiveData<Product> = _product
}