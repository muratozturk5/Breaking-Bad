package com.muratozturk.breakingbad.ui.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratozturk.breakingbad.common.Constants
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.domain.model.CharacterUI
import com.muratozturk.breakingbad.domain.use_case.character_list.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<Resource<CharacterUI>>(Resource.Loading)
    val state = _state.asStateFlow()

    init {
        savedStateHandle.get<Int>(Constants.PARAM_ID)?.let { getCharacter(it) }
    }

    private fun getCharacter(id: Int) = viewModelScope.launch {
        getCharacterUseCase(id).collect {
            _state.emit(it)
        }
    }
}