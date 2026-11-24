package com.example.trivify.data.datasources.remote.dto

data class RoomStatusResponseDto(
    val status: String,
    val players: List<PlayerDto>,
    val questions: List<QuestionDto>
)
