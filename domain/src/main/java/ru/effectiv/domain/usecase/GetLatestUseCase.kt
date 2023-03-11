package ru.effectiv.domain.usecase

import android.util.Log
import ru.effectiv.domain.model.latest.LatestX
import ru.effectiv.domain.repostory.latest.LatestRepository


class GetLatestUseCase(private val repository: LatestRepository) {
    suspend fun execute(): List<LatestX> {
        Log.e("SIZE", "execute: worked ${repository.getLatest().size}")
        return repository.getLatest()
    }
}