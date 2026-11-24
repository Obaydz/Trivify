package com.example.trivify.data.datasources.remote.dto

data class CreateRoomResponseDto (
    val roomCode: String,
    val hostName: String,
    val players: List<PlayerDto>
)