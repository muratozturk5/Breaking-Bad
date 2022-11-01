package com.muratozturk.breakingbad.data.mapper

import com.muratozturk.breakingbad.data.model.Episode
import com.muratozturk.breakingbad.data.model.Quote
import com.muratozturk.breakingbad.data.model.Character
import com.muratozturk.breakingbad.domain.model.CharacterDetailUI
import com.muratozturk.breakingbad.domain.model.CharacterUI
import com.muratozturk.breakingbad.domain.model.EpisodeUI
import com.muratozturk.breakingbad.domain.model.QuoteUI


fun Episode.toEpisodeUI(): EpisodeUI {
    return EpisodeUI(
        airDate = airDate,
        episode = episode,
        episodeId = episodeId,
        season = season,
        series = series,
        title = title
    )
}

fun Character.toCharacterUI(): CharacterUI {
    return CharacterUI(
        charId = charId,
        img = img,
        name = name
    )
}

fun Character.toCharacterDetailUI(): CharacterDetailUI {
    return CharacterDetailUI(
        appearance = appearance,
        birthday = birthday,
        category = category,
        charId = charId,
        img = img,
        name = name,
        nickname = nickname,
        occupation = occupation,
        portrayed = portrayed,
        status = status
    )
}

fun Quote.toQuoteUI(): QuoteUI {
    return QuoteUI(
        author = author,
        quote = quote,
        series = series
    )
}