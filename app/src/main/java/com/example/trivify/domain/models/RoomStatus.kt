package com.example.trivify.domain.models

data class RoomStatus(
    val status: String,
    val players: List<Player>,
    val questions: List<Question>
)
