package com.example.trivify.data.repositories

import com.example.trivify.data.datasources.remote.TriviaApi
import com.example.trivify.data.datasources.remote.dto.AnswerRequestDto
import com.example.trivify.data.datasources.remote.dto.AnswerResponseDto
import com.example.trivify.data.datasources.remote.dto.CreateRoomResponseDto
import com.example.trivify.data.datasources.remote.dto.JoinRoomResponseDto
import com.example.trivify.data.datasources.remote.dto.LeaderboardResponseDto
import com.example.trivify.data.datasources.remote.dto.RoomStatusResponseDto
import com.example.trivify.data.datasources.remote.dto.StartGameResponseDto
import com.example.trivify.data.datasources.remote.dto.UsernameRequestDto
import javax.inject.Inject

class TriviaRepositoryImpl @Inject constructor(private val api: TriviaApi) : TriviaRepository {
    override suspend fun createRoom(username: String): CreateRoomResponseDto {
        return api.createRoom(UsernameRequestDto(username))
    }

    override suspend fun joinRoom(
        roomCode: String,
        username: String
    ): JoinRoomResponseDto {
        return api.joinRoom(roomCode, UsernameRequestDto(username))
    }

    override suspend fun getRoomStatus(roomCode: String): RoomStatusResponseDto {
        return api.getRoomStatus(roomCode)
    }

    override suspend fun startGame(
        roomCode: String,
        username: String
    ): StartGameResponseDto {
        return api.startGame(roomCode, UsernameRequestDto(username))
    }

    override suspend fun submitAnswer(
        roomCode: String,
        username: String,
        questionId: Int,
        selectedIndex: Int
    ): AnswerResponseDto {
        return api.submitAnswer(roomCode, AnswerRequestDto(username, questionId, selectedIndex))
    }

    override suspend fun getLeaderboard(roomCode: String): LeaderboardResponseDto {
        return api.getLeaderboard(roomCode)
    }

}

