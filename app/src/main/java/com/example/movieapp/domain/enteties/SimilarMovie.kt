package com.example.movieapp.domain.enteties

import java.io.Serializable

data class SimilarMovie(
    val id: Int = 1,
    val name: String = "",
    val poster: Poster,
    val rating: Rating,
): Serializable {
    companion object {

        const val UNKNOWN_NAME = "Неизвестное название фильма"
    }
}