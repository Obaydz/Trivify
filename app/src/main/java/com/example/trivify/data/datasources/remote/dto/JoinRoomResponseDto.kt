package com.example.trivify.data.datasources.remote.dto

data class JoinRoomResponseDto(
    val roomCode: String,
    val status: String,
    val players: List<PlayerDto>
)
