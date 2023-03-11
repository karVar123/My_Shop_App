package ru.effectiv.domain.usecase

import ru.effectiv.domain.model.suggestion.Suggestions
import ru.effectiv.domain.repostory.suggestion.SuggestionRepository

class GetSuggestionUseCase(private val suggestionRepository: SuggestionRepository) {
    suspend fun execute(): Suggestions {
        return suggestionRepository.getAllSuggestion()
    }
}