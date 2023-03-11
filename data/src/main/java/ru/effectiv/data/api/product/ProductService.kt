package ru.effectiv.data.api.product

import retrofit2.http.GET
import ru.effectiv.domain.model.product.Product

interface ProductService {
    @GET("/v3/f7f99d04-4971-45d5-92e0-70333383c239")
    suspend fun getProduct(): Product
}
