package ru.effectiv.data.api.latest

import retrofit2.http.GET
import ru.effectiv.domain.model.latest.Latest

interface LatestService {
    @GET("v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatest(): Latest
}
