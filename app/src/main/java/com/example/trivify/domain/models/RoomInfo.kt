package com.example.trivify.domain.models

data class RoomInfo(
    val roomCode: String,
    val players: List<Player>
)
