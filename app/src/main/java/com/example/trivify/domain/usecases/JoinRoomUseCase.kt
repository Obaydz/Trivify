package com.example.trivify.domain.usecases

import com.example.trivify.common.Resource
import com.example.trivify.data.repositories.TriviaRepository
import com.example.trivify.domain.models.RoomInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JoinRoomUseCase @Inject constructor(
    private val repository: TriviaRepository
) {
    operator fun invoke(roomCode: String, username: String): Flow<Resource<RoomInfo>> = flow {
        try {
            emit(Resource.Loading())
            val roomInfo = repository.joinRoom(roomCode, username)
            emit(Resource.Success(roomInfo.toRoomInfo()))
        } catch(e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }
}