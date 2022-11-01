package com.muratozturk.breakingbadkotlin.presentation.character_list

import com.muratozturk.breakingbadkotlin.domain.model.CharacterUI

data class CharacterListState(
    var isLoading: Boolean = false,
    val characters: List<CharacterUI> = emptyList(),
    val error: String = ""
)
