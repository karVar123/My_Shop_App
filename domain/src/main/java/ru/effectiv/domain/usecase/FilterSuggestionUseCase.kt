package ru.effectiv.domain.usecase

import ru.effectiv.domain.repostory.suggestion.FilterSuggestionRepository


class FilterSuggestionUseCase(private val suggestionRepository: FilterSuggestionRepository) {
    suspend fun execute(text: String): List<String> {
        return suggestionRepository.filterSuggestion(text)
    }
}