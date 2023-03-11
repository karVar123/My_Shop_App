package ru.effectiv.mobile.di

import android.content.Context
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.effectiv.domain.usecase.*
import ru.effectiv.mobile.ui.pages.log_in.LogInViewModel
import ru.effectiv.mobile.ui.pages.page_1.home.HomeViewModel
import ru.effectiv.mobile.ui.pages.page_1.profile.ProfileViewModel
import ru.effectiv.mobile.ui.pages.product.Page2ViewModel
import ru.effectiv.mobile.ui.pages.sign_in.SignInViewModel

val appModule = module {
    viewModel<HomeViewModel> {
        HomeViewModel(
            latestUseCase = get<GetLatestUseCase>(),
            flashSaleUseCase = get<GetFlashSaleUseCase>(),
            filterSuggestionUseCase = get<FilterSuggestionUseCase>()
        )
    }
    viewModel<SignInViewModel> {
        SignInViewModel(
            toast_context = get<Context>(),
            insertPersonUseCase = get<InsertPersonUseCase>(),
            checkIsNotSuchPerson = get<CheckIsSuchPersonUseCase>(),
            saveUserEmailToSharedPrefUseCase = get<SaveUserEmailToSharedPrefUseCase>()
        )
    }
    viewModel<LogInViewModel> {
        LogInViewModel(
            checkIsNotSuchPersonUseCase = get<CheckIsSuchPersonUseCase>(),
            saveUserEmailToSharedPrefUseCase = get<SaveUserEmailToSharedPrefUseCase>()
        )
    }

    viewModel<Page2ViewModel> {
        Page2ViewModel(
            getProductUseCase = get<GetProductUseCase>()
        )
    }

    viewModel<ProfileViewModel> {
        ProfileViewModel(
            deleteUserEmailFromSharedPrefUseCase = get<DeleteUserEmailFromSharedPrefUseCase>()
        )
    }
}