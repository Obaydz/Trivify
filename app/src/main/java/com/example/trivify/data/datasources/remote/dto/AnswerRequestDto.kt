package com.example.trivify.data.datasources.remote.dto

data class AnswerRequestDto(
    val username: String,
    val questionId: Int,
    val selectedIndex: Int
)
