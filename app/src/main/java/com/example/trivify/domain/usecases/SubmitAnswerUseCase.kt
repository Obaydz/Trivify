package com.example.trivify.domain.usecases

import com.example.trivify.common.Resource
import com.example.trivify.data.repositories.TriviaRepository
import com.example.trivify.domain.models.AnswerResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SubmitAnswerUseCase @Inject constructor(
    private val repository: TriviaRepository
) {
    operator fun invoke(roomCode: String, username: String, questionId: Int, selectedIndex: Int): Flow<Resource<AnswerResult>> =
        flow {
            try {
                emit(Resource.Loading())
                val answerResult = repository.submitAnswer(roomCode, username, questionId, selectedIndex)
                emit(Resource.Success(answerResult.toAnswerResult()))
                } catch(e: Exception) {
                emit(Resource.Error(e.message ?: "An unexpected error occured"))
            }
        }
}