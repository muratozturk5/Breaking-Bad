package com.muratozturk.breakingbad.domain.use_case.qoute_list

import com.muratozturk.breakingbad.domain.repository.BreakingBadRepository
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: BreakingBadRepository
) {
    suspend operator fun invoke() = repository.getQuotes()

}