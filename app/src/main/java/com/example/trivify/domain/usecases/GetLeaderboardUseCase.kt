package com.example.trivify.domain.usecases

import com.example.trivify.common.Resource
import com.example.trivify.data.repositories.TriviaRepository
import com.example.trivify.domain.models.Player
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetLeaderboardUseCase @Inject constructor(
    private val repository: TriviaRepository
) {
    operator fun invoke(roomCode: String): Flow<Resource<List<Player>>> = flow {
        try {
            emit(Resource.Loading())
            val leaderboard = repository.getLeaderboard(roomCode)
            emit(Resource.Success(leaderboard.players.map { it.toPlayer() }))
        } catch (
            e: Exception
        ) {
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }
}