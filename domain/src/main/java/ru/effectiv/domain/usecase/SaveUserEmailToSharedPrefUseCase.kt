package ru.effectiv.domain.usecase

import ru.effectiv.domain.repostory.SharedPerfRepository

class SaveUserEmailToSharedPrefUseCase(private val sharedPerfRepository: SharedPerfRepository) {
    suspend fun execute(email: String) {
        sharedPerfRepository.saveCurrentUserEmail(email)
    }
}