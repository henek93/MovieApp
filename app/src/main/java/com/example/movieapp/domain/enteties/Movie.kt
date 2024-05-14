package com.example.movieapp.domain.enteties

import java.io.Serializable

data class Movie(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val poster: Poster = Poster(""),
    val rating: Rating = Rating(0.1),
    val isFavourite: Boolean = false,
    val pgRating: Int = 12,
    val type: String = "",
    val genres: List<Genre> = listOf(),
    val countries: List<Countries> = listOf(),
    val actors: List<ActorPoster> = listOf(),
    val similarMovies: List<SimilarMovie> = listOf(),
    val backdrop: Backdrop = Backdrop("", ""),
    val logo: Logo = Logo("")
): Serializable {

    companion object{

        const val NOT_ID = -1
        const val UNKNOWN_NAME = "Неизвестно название фильма"
        const val UNKNOWN_DESCRIPTION = "Нет описания"
        const val UNKNOWN_PG_RATING = -10
        const val UNKNOWN_TYPE = "Нет типа"
    }

}