package com.example.trivify.data.repositories

import com.example.trivify.data.datasources.remote.dto.AnswerResponseDto
import com.example.trivify.data.datasources.remote.dto.CreateRoomResponseDto
import com.example.trivify.data.datasources.remote.dto.JoinRoomResponseDto
import com.example.trivify.data.datasources.remote.dto.LeaderboardResponseDto
import com.example.trivify.data.datasources.remote.dto.RoomStatusResponseDto
import com.example.trivify.data.datasources.remote.dto.StartGameResponseDto

interface TriviaRepository {
    suspend fun createRoom(username: String): CreateRoomResponseDto
    suspend fun joinRoom(roomCode: String, username: String): JoinRoomResponseDto
    suspend fun getRoomStatus(roomCode: String): RoomStatusResponseDto
    suspend fun startGame(roomCode: String, username: String): StartGameResponseDto
    suspend fun submitAnswer(roomCode: String, username: String, questionId: Int, selectedIndex: Int): AnswerResponseDto
    suspend fun getLeaderboard(roomCode: String): LeaderboardResponseDto
}