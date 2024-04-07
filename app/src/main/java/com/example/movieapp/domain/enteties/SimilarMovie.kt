package com.example.movieapp.domain.enteties

data class SimilarMovie(
    val id: Int,
    val name: String,
    val poster: Poster,
    val rating: Rating,
) {
    companion object {

        const val UNKNOWN_NAME = "Неизвестное название фильма"
    }
}