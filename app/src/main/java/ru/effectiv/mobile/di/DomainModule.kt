package ru.effectiv.mobile.di

import android.content.Context
import ru.effectiv.domain.repostory.latest.LatestRepository
import org.koin.dsl.module
import ru.effectiv.data.repository_impl.*
import ru.effectiv.domain.repostory.PersonRepository
import ru.effectiv.domain.repostory.SharedPerfRepository
import ru.effectiv.domain.repostory.dao.PersonDao
import ru.effectiv.domain.repostory.flash_sales.FlashSaleRepository
import ru.effectiv.domain.repostory.product.ProductRepository
import ru.effectiv.domain.repostory.suggestion.FilterSuggestionRepository
import ru.effectiv.domain.repostory.suggestion.SuggestionRepository
import ru.effectiv.domain.usecase.*

const val KOIN_TAG = "KOIN_TAG"
val domainModule = module {
    factory<GetLatestUseCase> {
        GetLatestUseCase(repository = get<LatestRepository>())
    }

    factory<InsertPersonUseCase> {
        InsertPersonUseCase(personRepository = get<PersonRepository>())
    }


    factory<CheckIsSuchPersonUseCase> {
        CheckIsSuchPersonUseCase(personRepository = get<PersonRepository>())
    }

    factory<GetAllPersonsUseCase> {
        GetAllPersonsUseCase(personRepository = get<PersonRepository>())
    }
    factory<FilterSuggestionUseCase> {
        FilterSuggestionUseCase(suggestionRepository = get<FilterSuggestionRepository>())
    }

    factory<GetFlashSaleUseCase> {
        GetFlashSaleUseCase(repository = get<FlashSaleRepository>())
    }

    factory<GetSuggestionUseCase> {
        GetSuggestionUseCase(suggestionRepository = get<SuggestionRepository>())
    }

    factory<GetProductUseCase> {
        GetProductUseCase(productRepository = get<ProductRepository>())
    }
    factory<SaveUserEmailToSharedPrefUseCase> {
        SaveUserEmailToSharedPrefUseCase(sharedPerfRepository = get<SharedPerfRepository>())
    }

    factory<DeleteUserEmailFromSharedPrefUseCase> {
        DeleteUserEmailFromSharedPrefUseCase(sharedPerfRepository = get<SharedPerfRepository>())
    }
}