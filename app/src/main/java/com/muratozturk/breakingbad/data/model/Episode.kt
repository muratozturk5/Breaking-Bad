package com.muratozturk.breakingbad.data.model


import com.google.gson.annotations.SerializedName

data class Episode(
    @SerializedName("air_date")
    val airDate: String,
    val characters: List<String>,
    val episode: String,
    @SerializedName("episode_id")
    val episodeId: Int,
    val season: String,
    val series: String,
    val title: String
)