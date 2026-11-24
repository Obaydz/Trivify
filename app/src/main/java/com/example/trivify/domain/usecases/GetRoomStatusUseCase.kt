package com.example.trivify.domain.usecases

import com.example.trivify.common.Resource
import com.example.trivify.data.repositories.TriviaRepository
import com.example.trivify.domain.models.RoomStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRoomStatusUseCase @Inject constructor(
    private val repository: TriviaRepository
) {
    operator fun invoke(roomCode: String): Flow<Resource<RoomStatus>> = flow {
        try{
            emit(Resource.Loading())
            val roomStatus = repository.getRoomStatus(roomCode)
            emit(Resource.Success(roomStatus.toRoomStatus()))
        } catch(e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }
}