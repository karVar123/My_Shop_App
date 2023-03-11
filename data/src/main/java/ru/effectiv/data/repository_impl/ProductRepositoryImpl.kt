package ru.effectiv.data.repository_impl

import ru.effectiv.data.api.RetrofitInstance
import ru.effectiv.domain.model.product.Product
import ru.effectiv.domain.repostory.product.ProductRepository

class ProductRepositoryImpl : ProductRepository {
    override suspend fun getProduct(): Product = RetrofitInstance.productApi.getProduct()
}