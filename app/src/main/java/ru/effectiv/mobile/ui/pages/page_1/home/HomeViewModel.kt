package ru.effectiv.mobile.ui.pages.page_1.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.effectiv.domain.model.flash_sale.FlashSaleX
import ru.effectiv.domain.model.latest.LatestX
import ru.effectiv.domain.usecase.FilterSuggestionUseCase
import ru.effectiv.domain.usecase.GetFlashSaleUseCase
import ru.effectiv.domain.usecase.GetLatestUseCase

class HomeViewModel(
    private val latestUseCase: GetLatestUseCase,
    private val flashSaleUseCase: GetFlashSaleUseCase,
    private val filterSuggestionUseCase: FilterSuggestionUseCase,
) : ViewModel() {

    private val TAG = "ViewModel"
    private val _latest = MutableLiveData<List<LatestX>>().apply {
        viewModelScope.launch {
            Log.e(TAG, "latest: working checkSize::${latestUseCase.execute().size}")
            value = latestUseCase.execute()
        }
    }

    val latest: LiveData<List<LatestX>> = _latest

    private val _flashSale = MutableLiveData<List<FlashSaleX>>().apply {
        viewModelScope.launch {
            Log.e(TAG, "flashSale: working checkSize::${flashSaleUseCase.execute().size}")
            value = flashSaleUseCase.execute()
        }
    }

    val flashSale: LiveData<List<FlashSaleX>> = _flashSale

    suspend fun filterSuggestion(string: String): List<String> =
        filterSuggestionUseCase.execute(string)


}