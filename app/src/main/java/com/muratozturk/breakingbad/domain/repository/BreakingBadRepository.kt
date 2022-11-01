package com.muratozturk.breakingbad.domain.repository


import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.data.model.Episode
import com.muratozturk.breakingbad.data.model.Quote
import com.muratozturk.breakingbad.data.model.Character
import com.muratozturk.breakingbad.domain.model.CharacterUI
import com.muratozturk.breakingbad.domain.model.EpisodeUI
import com.muratozturk.breakingbad.domain.model.QuoteUI
import kotlinx.coroutines.flow.Flow

interface BreakingBadRepository {
    suspend fun getEpisodes(): Flow<Resource<List<EpisodeUI>>>
    suspend fun getCharacters(): Flow<Resource<List<CharacterUI>>>
    suspend fun getQuotes(): Flow<Resource<List<QuoteUI>>>
    suspend fun getEpisode(id: Int): Flow<Resource<EpisodeUI>>
    suspend fun getCharacter(id: Int): Flow<Resource<CharacterUI>>
}