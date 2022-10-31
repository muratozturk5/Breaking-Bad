package com.muratozturk.breakingbad.data.source

import com.muratozturk.breakingbad.data.model.Characters
import com.muratozturk.breakingbad.data.model.Death
import com.muratozturk.breakingbad.data.model.Episodes
import com.muratozturk.breakingbad.data.model.Quote
import com.muratozturk.breakingbad.domain.source.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val foodService: BreakingBadService) : RemoteDataSource {

    override suspend fun getCharacters(): Response<List<Characters>> = foodService.getCharacters()

    override suspend fun getEpisode(): Response<List<Episodes>> = foodService.getEpisodes()

    override suspend fun getDeath(): Response<List<Death>> = foodService.getDeath()

    override suspend fun getQuote(): Response<List<Quote>> = foodService.getQuote()

    override suspend fun getRandomCharacters(): Response<List<Characters>> =
        foodService.getRandomCharacter()

    override suspend fun getCharactersSearch(name: String): Response<List<Characters>> =
        foodService.getCharactersSearch(name)

    override suspend fun getCharacterDetail(id: Int): Response<Characters> =
        foodService.getCharacterDetail(id)

    override suspend fun getEpisodeDetail(id: Int): Response<Episodes> =
        foodService.getEpisodeDetail(id)
}