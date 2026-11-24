package com.example.trivify.data.datasources.remote.dto

import com.example.trivify.domain.models.Question

data class QuestionDto (
    val id : Int,
    val text: String,
    val options : List<String>
) {
    fun toQuestion() : Question {
        return Question(id, text, options)
    }
}