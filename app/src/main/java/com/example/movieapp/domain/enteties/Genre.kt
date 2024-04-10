package com.example.movieapp.domain.enteties

data class Genre(
    val name: String
) {
    companion object {
        const val UNKNOWN_NAME = "Неизвестный жанр"
        const val ADVENTURE_GENRE = "приключения"
        const val CRIMINAL_GENRE = "криминал"
    }
}