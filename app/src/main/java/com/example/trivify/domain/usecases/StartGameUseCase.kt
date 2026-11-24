package com.example.trivify.domain.usecases

import com.example.trivify.common.Resource
import com.example.trivify.data.repositories.TriviaRepository
import com.example.trivify.domain.models.Question
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StartGameUseCase @Inject constructor(
    private val repository: TriviaRepository
) {
    operator fun invoke(roomCode: String, username: String): Flow<Resource<List<Question>>> = flow {
        try {
            emit(Resource.Loading())
            val questions = repository.startGame(roomCode, username).questions
            emit(Resource.Success(questions.map { it.toQuestion() }))
        } catch(e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }
}