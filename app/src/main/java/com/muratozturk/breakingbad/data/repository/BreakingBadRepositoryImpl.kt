package com.muratozturk.breakingbad.data.repository


import androidx.lifecycle.MutableLiveData
import com.muratozturk.breakingbad.common.Resource
import com.muratozturk.breakingbad.data.model.Characters
import com.muratozturk.breakingbad.data.model.Death
import com.muratozturk.breakingbad.data.model.Episodes
import com.muratozturk.breakingbad.data.model.Quote
import com.muratozturk.breakingbad.data.source.RemoteDataSourceImpl
import com.muratozturk.breakingbad.domain.repository.BreakingBadRepository

class BreakingBadRepositoryImpl ( private val remoteDataSource:RemoteDataSourceImpl) :BreakingBadRepository{
    override suspend fun getCharacters(): MutableLiveData<Resource<List<Characters>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodes(): MutableLiveData<Resource<List<Episodes>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDeaths(): MutableLiveData<Resource<List<Death>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getQuote(): MutableLiveData<Resource<List<Quote>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomCharacter(): MutableLiveData<Resource<List<Characters>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharactersSearch(name: String): MutableLiveData<Resource<List<Characters>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterDetail(id: Int): MutableLiveData<Resource<Characters>> {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodeDetail(id: Int): MutableLiveData<Resource<Episodes>> {
        TODO("Not yet implemented")
    }


}