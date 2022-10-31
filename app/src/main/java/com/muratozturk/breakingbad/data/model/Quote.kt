package com.muratozturk.breakingbad.data.model


import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("author")
    val author: String,
    @SerializedName("quote")
    val quote: String,
    @SerializedName("quote_id")
    val quoteId: Int,
    @SerializedName("series")
    val series: String
)