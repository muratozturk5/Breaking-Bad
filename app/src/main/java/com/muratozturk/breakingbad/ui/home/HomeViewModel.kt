package com.muratozturk.breakingbad.ui.home

import androidx.lifecycle.ViewModel
import com.muratozturk.breakingbad.domain.repository.BreakingBadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val remoteRepositoryImpl: BreakingBadRepository) :
    ViewModel() {

        
}