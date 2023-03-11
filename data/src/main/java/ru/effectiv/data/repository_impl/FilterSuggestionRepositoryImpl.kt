package ru.effectiv.data.repository_impl

import android.content.ContentValues.TAG
import android.util.Log
import ru.effectiv.domain.repostory.suggestion.FilterSuggestionRepository
import ru.effectiv.domain.usecase.GetSuggestionUseCase

class FilterSuggestionRepositoryImpl(private val getSuggestionUseCase: GetSuggestionUseCase) :
    FilterSuggestionRepository {
    override suspend fun filterSuggestion(text: String): List<String> {
        val filteredList = mutableListOf<String>()
        if (text.isEmpty()) return emptyList() else {
            getSuggestionUseCase.execute().words.forEach {
                if (it.lowercase().startsWith(text.lowercase())) filteredList.add(it)
            }
        }
        Log.e(TAG, "filterSuggestion: text:: $text :: $filteredList ")
        return filteredList
    }
}