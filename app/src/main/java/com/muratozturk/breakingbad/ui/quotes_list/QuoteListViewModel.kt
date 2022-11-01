package com.muratozturk.breakingbad.ui.quotes_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.domain.model.EpisodeUI
import com.muratozturk.breakingbad.domain.model.QuoteUI
import com.muratozturk.breakingbad.domain.use_case.qoute_list.GetQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteListViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<Resource<List<QuoteUI>>>(Resource.Loading)
    val state = _state.asStateFlow()


    init {
        getQuotes()
    }

    private fun getQuotes() = viewModelScope.launch {
        getQuotesUseCase().collect {
            _state.emit(it)
        }
    }
}