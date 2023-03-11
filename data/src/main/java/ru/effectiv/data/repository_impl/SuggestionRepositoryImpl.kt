package ru.effectiv.data.repository_impl

import ru.effectiv.data.api.RetrofitInstance
import ru.effectiv.domain.model.suggestion.Suggestions
import ru.effectiv.domain.repostory.suggestion.SuggestionRepository

class SuggestionRepositoryImpl : SuggestionRepository {
    override suspend fun getAllSuggestion(): Suggestions =
        RetrofitInstance.suggestionApi.getSuggestion()


    override suspend fun filterSuggestion(string: String): List<String> {
        val filteredList = mutableListOf<String>()

        getAllSuggestion().words.forEach {
            if (it.startsWith(string)) filteredList.add(it)
        }
        return filteredList
    }
}