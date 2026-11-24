package com.example.trivify.domain.models

data class AnswerResult(
    val isCorrect: Boolean,
    val correctIndex: Int,
    val newScore: Int
)
