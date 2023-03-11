package ru.effectiv.domain.model.flash_sale

data class FlashSaleX(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)