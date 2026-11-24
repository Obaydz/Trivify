package com.example.trivify.data.datasources.remote.dto

data class QuestionDto (
    val id : Int,
    val text: String,
    val options : List<String>
)