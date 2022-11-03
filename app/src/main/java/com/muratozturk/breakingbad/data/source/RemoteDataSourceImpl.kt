package com.muratozturk.breakingbad.data.source

import com.muratozturk.breakingbad.data.model.Character
import com.muratozturk.breakingbad.data.model.Episode
import com.muratozturk.breakingbad.data.model.Quote
import com.muratozturk.breakingbad.domain.source.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl(private val remoteService: BreakingBadService) :
    RemoteDataSource {
    override suspend fun getEpisodes(): Response<List<Episode>> {
        return remoteService.getEpisodes()
    }

    override suspend fun getCharacters(): Response<List<Character>> {
        return remoteService.getCharacters()
    }

    override suspend fun getQuotes(): Response<List<Quote>> {
        return remoteService.getQuotes()
    }

    override suspend fun getEpisode(id: Int): Response<Episode> {
        return remoteService.getEpisode(id)
    }

    override suspend fun getCharacter(id: Int): Response<List<Character>> {
        return remoteService.getCharacter(id)
    }

}