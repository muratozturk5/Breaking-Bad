package com.muratozturk.breakingbadkotlin.presentation.episode_list

import com.muratozturk.breakingbadkotlin.domain.model.EpisodeUI

data class EpisodeListState(
    var isLoading: Boolean = false,
    val characters: List<EpisodeUI> = emptyList(),
    val error: String = ""
)
