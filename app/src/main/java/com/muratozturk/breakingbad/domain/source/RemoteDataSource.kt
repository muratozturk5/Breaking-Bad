package com.muratozturk.breakingbad.domain.source

import com.muratozturk.breakingbad.data.model.Characters
import com.muratozturk.breakingbad.data.model.Death
import com.muratozturk.breakingbad.data.model.Episodes
import com.muratozturk.breakingbad.data.model.Quote
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getCharacters(): Response<List<Characters>>
    suspend fun getEpisode(): Response<List<Episodes>>
    suspend fun getDeath(): Response<List<Death>>
    suspend fun getQuote(): Response<List<Quote>>
    suspend fun getRandomCharacters(): Response<List<Characters>>
    suspend fun getCharactersSearch(name: String): Response<List<Characters>>
    suspend fun getCharacterDetail(id: Int): Response<Characters>
    suspend fun getEpisodeDetail(id: Int): Response<Episodes>
}