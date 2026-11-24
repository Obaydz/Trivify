package com.example.trivify.data.datasources.remote.dto

import com.example.trivify.domain.models.AnswerResult

data class AnswerResponseDto(
    val isCorrect: Boolean,
    val correctIndex: Int,
    val newScore: Int
) {
    fun toAnswerResult(): AnswerResult {
        return AnswerResult(isCorrect, correctIndex, newScore)
    }
}
