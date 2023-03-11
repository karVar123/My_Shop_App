package ru.effectiv.domain.usecase

import ru.effectiv.domain.repostory.SharedPerfRepository

class DeleteUserEmailFromSharedPrefUseCase(private val sharedPerfRepository: SharedPerfRepository) {
    suspend fun execute() = sharedPerfRepository.deleteCurrentUserEmail()
}