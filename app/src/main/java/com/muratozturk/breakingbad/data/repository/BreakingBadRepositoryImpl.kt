package com.muratozturk.breakingbad.data.repository


import android.util.Log
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.data.mapper.toCharacterDetailUI
import com.muratozturk.breakingbad.data.mapper.toCharacterUI
import com.muratozturk.breakingbad.data.mapper.toEpisodeUI
import com.muratozturk.breakingbad.data.mapper.toQuoteUI
import com.muratozturk.breakingbad.data.source.RemoteDataSourceImpl
import com.muratozturk.breakingbad.domain.model.CharacterDetailUI
import com.muratozturk.breakingbad.domain.model.CharacterUI
import com.muratozturk.breakingbad.domain.model.EpisodeUI
import com.muratozturk.breakingbad.domain.model.QuoteUI
import com.muratozturk.breakingbad.domain.repository.BreakingBadRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BreakingBadRepositoryImpl(private val remoteDataSource: RemoteDataSourceImpl) :
    BreakingBadRepository {
    override suspend fun getEpisodes(): Flow<Resource<List<EpisodeUI>>> = flow {
        emit(Resource.Loading)
        try {
            emit(Resource.Success(remoteDataSource.getEpisodes().body()!!.map { it.toEpisodeUI() }))
        } catch (t: Throwable) {
            emit(Resource.Error(t))
        }
    }

    override suspend fun getCharacters(): Flow<Resource<List<CharacterUI>>> = flow {
        emit(Resource.Loading)
        try {
            emit(
                Resource.Success(remoteDataSource.getCharacters().body()!!
                    .map { it.toCharacterUI() })
            )
        } catch (t: Throwable) {
            emit(Resource.Error(t))
        }
    }

    override suspend fun getQuotes(): Flow<Resource<List<QuoteUI>>> = flow {
        emit(Resource.Loading)
        try {
            emit(Resource.Success(remoteDataSource.getQuotes().body()!!.map { it.toQuoteUI() }))
        } catch (t: Throwable) {
            emit(Resource.Error(t))
        }
    }

    override suspend fun getEpisode(id: Int): Flow<Resource<EpisodeUI>> = flow {
        emit(Resource.Loading)
        try {
            emit(Resource.Success(remoteDataSource.getEpisode(id).body()!!.toEpisodeUI()))
        } catch (t: Throwable) {
            emit(Resource.Error(t))
        }
    }

    override suspend fun getCharacter(id: Int): Flow<Resource<CharacterDetailUI>> = flow {
        emit(Resource.Loading)
        try {
            emit(
                Resource.Success(
                    remoteDataSource.getCharacter(id).body()!![0].toCharacterDetailUI()
                )
            )
        } catch (t: Throwable) {
            emit(Resource.Error(t))
        }
    }
}