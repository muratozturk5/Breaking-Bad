package com.muratozturk.breakingbad.domain.repository


import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.data.model.Characters
import com.muratozturk.breakingbad.data.model.Death
import com.muratozturk.breakingbad.data.model.Episodes
import com.muratozturk.breakingbad.data.model.Quote
import kotlinx.coroutines.flow.Flow

interface BreakingBadRepository {
    suspend fun getCharacters(): Flow<Resource<List<Characters>>>
    suspend fun getEpisodes(): Flow<Resource<List<Episodes>>>
    suspend fun getDeaths(): Flow<Resource<List<Death>>>
    suspend fun getQuote(): Flow<Resource<List<Quote>>>
    suspend fun getRandomCharacter(): Flow<Resource<List<Characters>>>
    suspend fun getCharactersSearch(name: String): Flow<Resource<List<Characters>>>
    suspend fun getCharacterDetail(id: Int): Flow<Resource<Characters>>
    suspend fun getEpisodeDetail(id: Int): Flow<Resource<Episodes>>
}