package com.example.trivify.data.datasources.remote.dto

import com.example.trivify.domain.models.RoomInfo

data class JoinRoomResponseDto(
    val roomCode: String,
    val status: String,
    val players: List<PlayerDto>
) {
    fun toRoomInfo(): RoomInfo {
        return RoomInfo(roomCode, players.map { it.toPlayer() })
    }
}
