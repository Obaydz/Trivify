package com.example.trivify.data.datasources.remote.dto

import com.example.trivify.domain.models.Player

data class PlayerDto (
    val username : String,
    val score : Int
) {
    fun toPlayer() : Player {
        return Player(username, score)
    }
}

