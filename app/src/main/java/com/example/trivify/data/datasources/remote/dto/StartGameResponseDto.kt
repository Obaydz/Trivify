package com.example.trivify.data.datasources.remote.dto

data class StartGameResponseDto(
    val status: String,
    val questions: List<QuestionDto>
)
