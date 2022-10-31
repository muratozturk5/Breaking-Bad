package com.muratozturk.breakingbad.domain.repository

import androidx.lifecycle.MutableLiveData
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.data.model.Characters
import com.muratozturk.breakingbad.data.model.Death
import com.muratozturk.breakingbad.data.model.Episodes
import com.muratozturk.breakingbad.data.model.Quote

interface BreakingBadRepository {
    suspend fun getCharacters(): MutableLiveData<Resource<List<Characters>>>
    suspend fun getEpisodes(): MutableLiveData<Resource<List<Episodes>>>
    suspend fun getDeaths(): MutableLiveData<Resource<List<Death>>>
    suspend fun getQuote(): MutableLiveData<Resource<List<Quote>>>
    suspend fun getRandomCharacter(): MutableLiveData<Resource<List<Characters>>>
    suspend fun getCharactersSearch(name: String): MutableLiveData<Resource<List<Characters>>>
    suspend fun getCharacterDetail(id: Int): MutableLiveData<Resource<Characters>>
    suspend fun getEpisodeDetail(id: Int): MutableLiveData<Resource<Episodes>>
}