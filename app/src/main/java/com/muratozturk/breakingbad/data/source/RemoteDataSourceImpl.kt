package com.muratozturk.breakingbad.data.source

import com.muratozturk.breakingbad.data.model.Characters
import com.muratozturk.breakingbad.data.model.Death
import com.muratozturk.breakingbad.data.model.Episodes
import com.muratozturk.breakingbad.data.model.Quote
import com.muratozturk.breakingbad.domain.source.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val remoteService: BreakingBadService) : RemoteDataSource {

    override suspend fun getCharacters(): Response<List<Characters>> = remoteService.getCharacters()

    override suspend fun getEpisode(): Response<List<Episodes>> = remoteService.getEpisodes()

    override suspend fun getDeath(): Response<List<Death>> = remoteService.getDeath()

    override suspend fun getQuote(): Response<List<Quote>> = remoteService.getQuote()

    override suspend fun getRandomCharacters(): Response<List<Characters>> =
        remoteService.getRandomCharacter()

    override suspend fun getCharactersSearch(name: String): Response<List<Characters>> =
        remoteService.getCharactersSearch(name)

    override suspend fun getCharacterDetail(id: Int): Response<Characters> =
        remoteService.getCharacterDetail(id)

    override suspend fun getEpisodeDetail(id: Int): Response<Episodes> =
        remoteService.getEpisodeDetail(id)
}