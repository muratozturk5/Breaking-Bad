package com.muratozturk.breakingbad.domain.use_case.episode_detail

import com.muratozturk.breakingbad.domain.repository.BreakingBadRepository
import javax.inject.Inject

class GetEpisodeUseCase @Inject constructor(
    private val repository: BreakingBadRepository
) {
    suspend operator fun invoke(id: Int) = repository.getEpisode(id)
}