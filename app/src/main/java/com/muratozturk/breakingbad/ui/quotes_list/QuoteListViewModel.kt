package com.muratozturk.breakingbadkotlin.presentation.quotes_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratozturk.breakingbadkotlin.common.Resource
import com.muratozturk.breakingbadkotlin.domain.use_case.get_quotes.GetQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class QuoteListViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(QuoteListState())
    val state: StateFlow<QuoteListState> = _state.asStateFlow()

    init {
        getQuotes()
    }

    private fun getQuotes() {
        getQuotesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = QuoteListState(characters = result.data)
                }
                is Resource.Error -> {
                    _state.value = QuoteListState(error = result.throwable.localizedMessage ?: "")
                }
                is Resource.Loading -> {
                    _state.value = QuoteListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}