package ru.effectiv.mobile.ui.pages.log_in


import androidx.lifecycle.ViewModel
import ru.effectiv.domain.usecase.CheckIsSuchPersonUseCase
import ru.effectiv.domain.usecase.SaveUserEmailToSharedPrefUseCase

class LogInViewModel(
    private val checkIsNotSuchPersonUseCase: CheckIsSuchPersonUseCase,
    private val saveUserEmailToSharedPrefUseCase: SaveUserEmailToSharedPrefUseCase,
) : ViewModel() {

    suspend fun checkIsExistAccount(email: String): Boolean {
        return if (!checkIsNotSuchPersonUseCase.execute(email)) {
            saveUserEmailToSharedPrefUseCase.execute(email)
            true
        } else false
    }
}