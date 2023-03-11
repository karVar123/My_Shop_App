package ru.effectiv.data.api.suggestion

import retrofit2.http.GET
import ru.effectiv.domain.model.suggestion.Suggestions

interface SuggestionService {
    @GET("v3/4c9cd822-9479-4509-803d-63197e5a9e19")
    suspend fun getSuggestion(): Suggestions
}
