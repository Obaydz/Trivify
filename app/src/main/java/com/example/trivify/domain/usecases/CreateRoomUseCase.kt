package com.example.trivify.domain.usecases

import com.example.trivify.common.Resource
import com.example.trivify.data.repositories.TriviaRepository
import com.example.trivify.domain.models.RoomInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreateRoomUseCase @Inject constructor(
    private val repository: TriviaRepository
) {
    operator fun invoke(username: String): Flow<Resource<RoomInfo>> = flow {
        try {
            emit(Resource.Loading())
            val roomInfo = repository.createRoom(username)
            emit(Resource.Success(roomInfo.toRoomInfo()))
        } catch(e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }
}