package ru.clevertec.nikonov.androidperformance.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ru.clevertec.nikonov.androidperformance.data.dto.Product
import ru.clevertec.nikonov.androidperformance.data.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class ProductsViewModel : ViewModel() {

    private var repository: ProductsRepository? = null

    val productsFlow: StateFlow<List<Product>> get() = _productsFlow.asStateFlow()
    private val _productsFlow = MutableStateFlow<List<Product>>(emptyList())

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            if (repository == null) repository = ProductsRepository()

            _productsFlow.value = repository!!.getProducts()
        }
    }
}