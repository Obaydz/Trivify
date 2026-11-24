package com.example.trivify.domain.models

data class Question(
    val id : Int,
    val text: String,
    val options : List<String>
)
