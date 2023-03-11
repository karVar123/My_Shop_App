package ru.effectiv.domain.repostory.latest

import ru.effectiv.domain.model.latest.LatestX

interface LatestRepository {
    suspend fun getLatest(): List<LatestX>
}