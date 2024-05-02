package com.example.movieapp.domain.enteties

import java.io.Serializable

data class Genre(
    val name: String
): Serializable {
    companion object {
        const val UNKNOWN_NAME = "Неизвестный жанр"
        const val ADVENTURE_GENRE = "приключения"
        const val CRIMINAL_GENRE = "криминал"
    }
}