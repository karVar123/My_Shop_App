package ru.effectiv.domain.usecase

import ru.effectiv.domain.model.product.Product
import ru.effectiv.domain.repostory.product.ProductRepository

class GetProductUseCase(private val productRepository: ProductRepository) {
    suspend fun execute(): Product = productRepository.getProduct()

}