package ru.clevertec.nikonov.androidperformance.data.repository

import ru.clevertec.nikonov.androidperformance.data.mock.ProductsMockApi

internal class ProductsRepository() {

    suspend fun getProducts() = ProductsMockApi.products
}