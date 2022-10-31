package com.muratozturk.breakingbad.data.source

import com.muratozturk.breakingbad.common.Constants.CHARACTERS
import com.muratozturk.breakingbad.common.Constants.CHARACTERS_DETAIL
import com.muratozturk.breakingbad.common.Constants.DEATH
import com.muratozturk.breakingbad.common.Constants.EPISODES
import com.muratozturk.breakingbad.common.Constants.EPISODES_DETAIL
import com.muratozturk.breakingbad.common.Constants.QUOTE
import com.muratozturk.breakingbad.common.Constants.RANDOM_CHARACTER
import com.muratozturk.breakingbad.data.model.Characters
import com.muratozturk.breakingbad.data.model.Death
import com.muratozturk.breakingbad.data.model.Episodes
import com.muratozturk.breakingbad.data.model.Quote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BreakingBadService {
    @GET(CHARACTERS)
    suspend fun getCharacters(): Response<List<Characters>>

    @GET(EPISODES)
    suspend fun getEpisodes(): Response<List<Episodes>>

    @GET(DEATH)
    suspend fun getDeath(): Response<List<Death>>

    @GET(QUOTE)
    suspend fun getQuote(): Response<List<Quote>>

    @GET(RANDOM_CHARACTER)
    suspend fun getRandomCharacter(): Response<List<Characters>>

    @GET(CHARACTERS)
    suspend fun getCharactersSearch(@Query("name") name: String): Response<List<Characters>>

    @GET(CHARACTERS_DETAIL)
    suspend fun getCharacterDetail(@Path("id")id:Int): Response<Characters>

    @GET(EPISODES_DETAIL)
    suspend fun getEpisodeDetail(@Path("id")id:Int): Response<Episodes>


}