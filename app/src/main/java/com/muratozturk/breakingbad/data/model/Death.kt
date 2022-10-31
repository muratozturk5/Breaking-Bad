package com.muratozturk.breakingbad.data.model


import com.google.gson.annotations.SerializedName
data class Death(
    @SerializedName("cause")
    val cause: String,
    @SerializedName("death")
    val death: String,
    @SerializedName("death_id")
    val deathId: Int,
    @SerializedName("episode")
    val episode: Int,
    @SerializedName("last_words")
    val lastWords: String,
    @SerializedName("number_of_deaths")
    val numberOfDeaths: Int,
    @SerializedName("responsible")
    val responsible: String,
    @SerializedName("season")
    val season: Int
)
