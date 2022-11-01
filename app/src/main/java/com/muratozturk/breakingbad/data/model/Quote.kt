package com.muratozturk.breakingbad.data.model


import com.google.gson.annotations.SerializedName

data class Quote(
    val author: String,
    val quote: String,
    @SerializedName("quote_id")
    val quoteId: Int,
    val series: String
)