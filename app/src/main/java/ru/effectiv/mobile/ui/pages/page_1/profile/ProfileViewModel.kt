package ru.effectiv.mobile.ui.pages.page_1.profile

import androidx.lifecycle.ViewModel
import ru.effectiv.domain.usecase.DeleteUserEmailFromSharedPrefUseCase

class ProfileViewModel(private val deleteUserEmailFromSharedPrefUseCase: DeleteUserEmailFromSharedPrefUseCase) :
    ViewModel() {
    suspend fun logOut(): Boolean = try {
        deleteUserEmailFromSharedPrefUseCase.execute()
        true
    } catch (ex: Exception) {
        false
    }
}
