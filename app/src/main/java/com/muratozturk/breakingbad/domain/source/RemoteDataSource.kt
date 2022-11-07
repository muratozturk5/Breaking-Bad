package com.muratozturk.breakingbad.domain.source

import com.muratozturk.breakingbad.data.model.Character
import com.muratozturk.breakingbad.data.model.Episode
import com.muratozturk.breakingbad.data.model.Quote

interface RemoteDataSource {
    suspend fun getEpisodes(): List<Episode>
    suspend fun getCharacters(): List<Character>
    suspend fun getQuotes(): List<Quote>
    suspend fun getEpisode(id: Int): Episode
    suspend fun getCharacter(id: Int): List<Character>
}