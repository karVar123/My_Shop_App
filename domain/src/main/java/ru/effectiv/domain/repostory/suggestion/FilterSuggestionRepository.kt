package ru.effectiv.domain.repostory.suggestion

interface FilterSuggestionRepository {
    suspend fun filterSuggestion(text: String): List<String>

}
