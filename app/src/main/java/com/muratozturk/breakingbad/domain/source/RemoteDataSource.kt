package com.muratozturk.breakingbad.domain.source

import com.muratozturk.breakingbad.data.model.Character
import com.muratozturk.breakingbad.data.model.Episode
import com.muratozturk.breakingbad.data.model.Quote
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getEpisodes(): Response<List<Episode>>
    suspend fun getCharacters(): Response<List<Character>>
    suspend fun getQuotes(): Response<List<Quote>>
    suspend fun getEpisode(id: Int): Response<Episode>
    suspend fun getCharacter(id: Int): Response<List<Character>>
}