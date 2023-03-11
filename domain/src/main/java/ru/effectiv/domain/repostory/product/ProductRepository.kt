package ru.effectiv.domain.repostory.product

import ru.effectiv.domain.model.product.Product

interface ProductRepository {
    suspend fun getProduct(): Product
}