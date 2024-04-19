package ru.clevertec.nikonov.androidperformance.data.dto

internal class Product(
    val id: String,
    val title: String,
    val imageUrl: String,
    val rate: Double,
    val description: List<String>,
    val price: Double,
    val offerDetails: List<String>
)