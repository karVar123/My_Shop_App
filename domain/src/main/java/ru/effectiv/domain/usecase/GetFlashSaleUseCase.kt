package ru.effectiv.domain.usecase

import ru.effectiv.domain.model.flash_sale.FlashSaleX
import ru.effectiv.domain.repostory.flash_sales.FlashSaleRepository

class GetFlashSaleUseCase (private val repository: FlashSaleRepository) {
    suspend fun execute(): List<FlashSaleX> = repository.getFlashSale()
}