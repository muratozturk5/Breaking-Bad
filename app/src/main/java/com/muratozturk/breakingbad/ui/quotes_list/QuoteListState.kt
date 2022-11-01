package com.muratozturk.breakingbadkotlin.presentation.quotes_list

import com.muratozturk.breakingbadkotlin.domain.model.QuoteUI

data class QuoteListState(
    var isLoading: Boolean = false,
    val characters: List<QuoteUI> = emptyList(),
    val error: String = ""
)
