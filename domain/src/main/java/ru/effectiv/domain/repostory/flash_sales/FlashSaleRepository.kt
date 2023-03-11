package ru.effectiv.domain.repostory.flash_sales

import ru.effectiv.domain.model.flash_sale.FlashSaleX

interface FlashSaleRepository {
    suspend fun getFlashSale(): List<FlashSaleX>
}