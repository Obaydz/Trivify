package com.example.trivify.data.datasources.remote

import com.example.trivify.data.datasources.remote.dto.AnswerRequestDto
import com.example.trivify.data.datasources.remote.dto.AnswerResponseDto
import com.example.trivify.data.datasources.remote.dto.CreateRoomResponseDto
import com.example.trivify.data.datasources.remote.dto.JoinRoomResponseDto
import com.example.trivify.data.datasources.remote.dto.LeaderboardResponseDto
import com.example.trivify.data.datasources.remote.dto.RoomStatusResponseDto
import com.example.trivify.data.datasources.remote.dto.StartGameResponseDto
import com.example.trivify.data.datasources.remote.dto.UsernameRequestDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TriviaApi {

    @POST("rooms")
    suspend fun createRoom(
        @Body request: UsernameRequestDto
    ): CreateRoomResponseDto

    @POST("rooms/{code}/join")
    suspend fun joinRoom(
        @Path("code") code: String,
        @Body request: UsernameRequestDto
    ): JoinRoomResponseDto

    @GET("rooms/{code}/status")
    suspend fun getRoomStatus(
        @Path("code") code: String
    ): RoomStatusResponseDto

    @POST("rooms/{code}/start")
    suspend fun startGame(
        @Path("code") code: String,
        @Body request: UsernameRequestDto
    ): StartGameResponseDto

    @POST("rooms/{code}/answer")
    suspend fun submitAnswer(
        @Path("code") code: String,
        @Body request: AnswerRequestDto
    ): AnswerResponseDto

    @GET("rooms/{code}/leaderboard")
    suspend fun getLeaderboard(
        @Path("code") code: String
    ): LeaderboardResponseDto
}