package ru.effectiv.data.repository_impl

import ru.effectiv.data.api.RetrofitInstance
import ru.effectiv.domain.repostory.latest.LatestRepository
import ru.effectiv.domain.model.latest.LatestX

class LatestRepositoryImpl(): LatestRepository {
    override suspend fun getLatest(): List<LatestX> = RetrofitInstance.latestApi.getLatest().latest
}