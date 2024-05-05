package com.example.movieapp.domain.enteties

import java.io.Serializable

data class Movie(
    val id: Int,
    val name: String,
    val description: String,
    val poster: Poster,
    val rating: Rating,
    val isFavourite: Boolean,
    val pgRating: Int,
    val type: String,
    val genres: List<Genre>,
    val countries: List<Countries>,
    val actors: List<ActorPoster>,
    val similarMovies: List<SimilarMovie>,
    val backdrop: Backdrop,
    val logo: Logo
): Serializable {

    companion object{

        const val NOT_ID = -1
        const val UNKNOWN_NAME = "Неизвестно название фильма"
        const val UNKNOWN_DESCRIPTION = "Нет описания"
        const val UNKNOWN_PG_RATING = -10
        const val UNKNOWN_TYPE = "Нет типа"
    }

}