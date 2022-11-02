package com.muratozturk.breakingbad.data.model


import com.google.gson.annotations.SerializedName

data class Character(
    val appearance: List<Int>,
    @SerializedName("better_call_saul_appearance")
    val betterCallSaulAppearance: List<Int>,
    val birthday: String,
    val category: String,
    @SerializedName("char_id")
    val charId: Int,
    val img: String,
    val name: String,
    val nickname: String,
    val occupation: List<String>,
    val portrayed: String,
    val status: String
)