package com.example.movieapp.domain.enteties

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
    val actors: List<Actor>,
    val similarMovies: List<SimilarMovie>,
    val backdrop: Backdrop,
    val logo: Logo
){

    companion object{

        const val NOT_ID = -1
        const val UNKNOWN_NAME = "Неизвестно название фильма"
        const val UNKNOWN_DESCRIPTION = "Нет описания"
        const val UNKNOWN_PG_RATING = -10
        const val UNKNOWN_TYPE = "Нет типа"
    }

}