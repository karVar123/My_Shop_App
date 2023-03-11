package ru.effectiv.domain.repostory

interface SharedPerfRepository {
    suspend fun deleteCurrentUserEmail()

    suspend fun saveCurrentUserEmail(currentUserEmail: String)

}