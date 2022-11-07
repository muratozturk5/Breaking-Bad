package com.muratozturk.breakingbad.data.source

import com.muratozturk.breakingbad.common.Constants.CHARACTERS
import com.muratozturk.breakingbad.common.Constants.CHARACTERS_DETAIL
import com.muratozturk.breakingbad.common.Constants.EPISODES
import com.muratozturk.breakingbad.common.Constants.EPISODES_DETAIL
import com.muratozturk.breakingbad.common.Constants.QUOTE
import com.muratozturk.breakingbad.data.model.Character
import com.muratozturk.breakingbad.data.model.Episode
import com.muratozturk.breakingbad.data.model.Quote
import retrofit2.http.GET
import retrofit2.http.Path

interface BreakingBadService {
    @GET(EPISODES)
    suspend fun getEpisodes(): List<Episode>

    @GET(CHARACTERS)
    suspend fun getCharacters(): List<Character>

    @GET(QUOTE)
    suspend fun getQuotes(): List<Quote>

    @GET(EPISODES_DETAIL)
    suspend fun getEpisode(@Path("id") id: Int): Episode

    @GET(CHARACTERS_DETAIL)
    suspend fun getCharacter(@Path("id") id: Int): List<Character>
}