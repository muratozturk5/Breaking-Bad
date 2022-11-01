package com.muratozturk.breakingbad.domain.use_case.character_list

import com.muratozturk.breakingbad.domain.repository.BreakingBadRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: BreakingBadRepository
) {

    suspend operator fun invoke() = repository.getCharacters()

}