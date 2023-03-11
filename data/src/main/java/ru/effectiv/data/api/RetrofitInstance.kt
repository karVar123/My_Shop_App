package ru.effectiv.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.effectiv.data.api.latest.LatestService
import ru.effectiv.data.api.product.ProductService
import ru.effectiv.data.api.slash_sale.FlashSaleService
import ru.effectiv.data.api.suggestion.SuggestionService


object RetrofitInstance {
    private const val BASE_URL = "https://run.mocky.io/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val latestApi: LatestService by lazy {
        retrofit.create(LatestService::class.java)
    }

    val flashSaleApi: FlashSaleService by lazy {
        retrofit.create(FlashSaleService::class.java)
    }

    val suggestionApi: SuggestionService by lazy {
        retrofit.create(SuggestionService::class.java)
    }
    val productApi: ProductService by lazy {
        retrofit.create(ProductService::class.java)
    }


}