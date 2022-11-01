package com.muratozturk.breakingbadkotlin.presentation.episode_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratozturk.breakingbadkotlin.common.Resource
import com.muratozturk.breakingbadkotlin.domain.use_case.get_episodes.GetEpisodesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class EpisodeListViewModel @Inject constructor(
    private val getEpisodesUseCase: GetEpisodesUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(EpisodeListState())
    val state: StateFlow<EpisodeListState> = _state.asStateFlow()

    init {
        getEpisodes()
    }

    private fun getEpisodes() {
        getEpisodesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        EpisodeListState(characters = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        EpisodeListState(error = result.throwable.localizedMessage ?: "")
                }
                is Resource.Loading -> {
                    _state.value = EpisodeListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}