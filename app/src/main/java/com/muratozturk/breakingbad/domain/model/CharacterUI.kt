package com.muratozturk.breakingbad.domain.model

data class CharacterUI(
    val appearance: List<Int>,
    val birthday: String,
    val category: String,
    val charId: Int,
    val img: String,
    val name: String,
    val nickname: String,
    val occupation: List<String>,
    val portrayed: String,
    val status: String
)
