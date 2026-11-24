package com.example.trivify.data.datasources.remote.dto

data class AnswerResponseDto(
    val isCorrect: Boolean,
    val correctIndex: Int,
    val newScore: Int
)
