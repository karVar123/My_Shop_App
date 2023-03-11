package ru.effectiv.domain.repostory.suggestion

import ru.effectiv.domain.model.suggestion.Suggestions

interface SuggestionRepository {
    suspend fun getAllSuggestion(): Suggestions

    suspend fun filterSuggestion(string: String): List<String>
}