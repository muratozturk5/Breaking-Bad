package com.muratozturk.breakingbad.ui.character_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratozturk.breakingbad.common.Constants.PARAM_ID
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.domain.model.CharacterDetailUI
import com.muratozturk.breakingbad.domain.model.CharacterUI
import com.muratozturk.breakingbad.domain.use_case.detail.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state = MutableStateFlow<Resource<CharacterDetailUI>>(Resource.Loading)
    val state = _state.asStateFlow()

    init {
        savedStateHandle.get<Int>(PARAM_ID)?.let { getCharacter(it) }
    }

    private fun getCharacter(id: Int) = viewModelScope.launch {
        getCharacterUseCase(id).collect {
            _state.emit(it)
        }
    }
}