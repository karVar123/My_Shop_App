package ru.effectiv.data.api.slash_sale

import retrofit2.http.GET
import ru.effectiv.domain.model.flash_sale.FlashSale

interface FlashSaleService {
    @GET("v3/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getLatest(): FlashSale
}
