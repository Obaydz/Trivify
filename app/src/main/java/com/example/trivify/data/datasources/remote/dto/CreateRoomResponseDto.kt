package com.example.trivify.data.datasources.remote.dto

import com.example.trivify.domain.models.RoomInfo

data class CreateRoomResponseDto (
    val roomCode: String,
    val hostName: String,
    val players: List<PlayerDto>
) {
    fun toRoomInfo() : RoomInfo {
        return RoomInfo(roomCode, players.map { it.toPlayer() })
    }
}