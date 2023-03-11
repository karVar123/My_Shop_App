package ru.effectiv.data.repository_impl

import ru.effectiv.data.api.RetrofitInstance
import ru.effectiv.domain.model.flash_sale.FlashSaleX
import ru.effectiv.domain.repostory.flash_sales.FlashSaleRepository

class FlashSaleRepositoryImpl : FlashSaleRepository {
    override suspend fun getFlashSale(): List<FlashSaleX> =
        RetrofitInstance.flashSaleApi.getLatest().flash_sale
}