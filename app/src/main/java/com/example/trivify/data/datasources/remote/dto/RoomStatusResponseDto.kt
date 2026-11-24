package com.example.trivify.data.datasources.remote.dto

import com.example.trivify.domain.models.RoomStatus

data class RoomStatusResponseDto(
    val status: String,
    val players: List<PlayerDto>,
    val questions: List<QuestionDto>
) {
    fun toRoomStatus(): RoomStatus {
        return RoomStatus(status, players.map { it.toPlayer() }, questions.map { it.toQuestion() })
    }
}
