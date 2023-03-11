package ru.effectiv.mobile.di

import android.content.Context
import android.util.Log
import ru.effectiv.domain.repostory.latest.LatestRepository
import org.koin.dsl.module
import ru.effectiv.data.database.PersonDatabase
import ru.effectiv.data.repository_impl.*
import ru.effectiv.domain.repostory.PersonRepository
import ru.effectiv.domain.repostory.SharedPerfRepository
import ru.effectiv.domain.repostory.dao.PersonDao
import ru.effectiv.domain.repostory.flash_sales.FlashSaleRepository
import ru.effectiv.domain.repostory.product.ProductRepository
import ru.effectiv.domain.repostory.suggestion.FilterSuggestionRepository
import ru.effectiv.domain.repostory.suggestion.SuggestionRepository
import ru.effectiv.domain.usecase.GetSuggestionUseCase

val dataModule = module {
    single<LatestRepository> {
        LatestRepositoryImpl()
    }
    single<PersonDatabase> {
        PersonDatabase.invoke(context = get())
    }

    single<PersonDao> {
        get<PersonDatabase>().personDao()
    }

    single<PersonRepository> {
        PersonRepository(personDao = get<PersonDao>())
    }

    single<FlashSaleRepository> {
        FlashSaleRepositoryImpl()
    }
    single<SharedPerfRepository> {
        SharedPerfRepositoryImpl(context = get<Context>())
    }
    single<ProductRepository> {
        ProductRepositoryImpl()
    }

    single<FilterSuggestionRepository> {
        FilterSuggestionRepositoryImpl(getSuggestionUseCase = get<GetSuggestionUseCase>())
    }

    single<SuggestionRepository> {
        SuggestionRepositoryImpl()
    }
}
