package ru.effectiv.mobile.ui.pages.sign_in


import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.effectiv.domain.model.person.Person
import ru.effectiv.domain.usecase.CheckIsSuchPersonUseCase
import ru.effectiv.domain.usecase.InsertPersonUseCase
import ru.effectiv.domain.usecase.SaveUserEmailToSharedPrefUseCase

class SignInViewModel(
    private val toast_context: Context,
    private val insertPersonUseCase: InsertPersonUseCase,
    private val checkIsNotSuchPerson: CheckIsSuchPersonUseCase,
    private val saveUserEmailToSharedPrefUseCase: SaveUserEmailToSharedPrefUseCase,
) : ViewModel() {
    suspend fun userRegistration(personEntity: Person): Boolean {
        var response: Boolean = true
        try {
            val existingPerson = checkIsNotSuchPerson.execute(personEntity.email)

            viewModelScope.async {
                response = if (existingPerson) {
                    insertPersonUseCase.invoke(personEntity)
                    saveUserEmailToSharedPrefUseCase.execute(personEntity.email)
                    true
                } else {
                    Toast.makeText(toast_context, "There is a similar user", Toast.LENGTH_SHORT)
                        .show()
                    false
                }

            }
        } catch (ex: Exception) {
            Log.e("SignInViewModel", "userRegistration: exception :: ${ex.message}")
            response = false
        }
        return response
    }
}