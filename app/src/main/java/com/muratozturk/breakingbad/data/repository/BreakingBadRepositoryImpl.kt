package com.muratozturk.breakingbad.data.repository



import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.data.model.Characters
import com.muratozturk.breakingbad.data.model.Death
import com.muratozturk.breakingbad.data.model.Episodes
import com.muratozturk.breakingbad.data.model.Quote
import com.muratozturk.breakingbad.data.source.RemoteDataSourceImpl
import com.muratozturk.breakingbad.domain.repository.BreakingBadRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class BreakingBadRepositoryImpl(private val remoteDataSource: RemoteDataSourceImpl) :
    BreakingBadRepository {
    override suspend fun getCharacters(): Flow<Resource<List<Characters>>> = flow {

        emit(Resource.Loading)
        try {
            emit(Resource.Success(remoteDataSource.getCharacters().body()!!))

        } catch (e: IOException) {
            emit(Resource.Error(e))

        }

    }


    override suspend fun getEpisodes(): Flow<Resource<List<Episodes>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDeaths(): Flow<Resource<List<Death>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getQuote(): Flow<Resource<List<Quote>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomCharacter(): Flow<Resource<List<Characters>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharactersSearch(name: String): Flow<Resource<List<Characters>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterDetail(id: Int): Flow<Resource<Characters>> {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodeDetail(id: Int): Flow<Resource<Episodes>> {
        TODO("Not yet implemented")
    }


}