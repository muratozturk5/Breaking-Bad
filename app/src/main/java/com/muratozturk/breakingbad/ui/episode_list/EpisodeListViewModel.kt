package com.muratozturk.breakingbad.ui.episode_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.domain.model.EpisodeUI
import com.muratozturk.breakingbad.domain.use_case.episode_list.GetEpisodesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeListViewModel @Inject constructor(
    private val getEpisodesUseCase: GetEpisodesUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<Resource<List<EpisodeUI>>>(Resource.Loading)
    val state = _state.asStateFlow()

    init {
        getEpisodes()
    }

    private fun getEpisodes() = viewModelScope.launch {
        getEpisodesUseCase().collect {
            _state.emit(it)
        }
    }
}