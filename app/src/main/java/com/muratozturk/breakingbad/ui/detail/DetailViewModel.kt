package com.muratozturk.breakingbad.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.data.model.Characters
import com.muratozturk.breakingbad.domain.repository.BreakingBadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val remoteRepositoryImpl: BreakingBadRepository) :
    ViewModel() {

    private var _character = MutableStateFlow<Resource<Characters>>(Resource.Loading)
    val character = _character.asStateFlow()


    fun getCharacter(id: Int) {
        viewModelScope.launch {
            remoteRepositoryImpl.getCharacterDetail(id).collect {
                _character.emit(it)
            }

        }

    }
}