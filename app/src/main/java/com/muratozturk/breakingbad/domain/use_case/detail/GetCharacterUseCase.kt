package com.muratozturk.breakingbad.domain.use_case.detail

import com.muratozturk.breakingbad.domain.repository.BreakingBadRepository

import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: BreakingBadRepository
) {
    suspend operator  fun invoke(id: Int) = repository.getCharacter(id)

}