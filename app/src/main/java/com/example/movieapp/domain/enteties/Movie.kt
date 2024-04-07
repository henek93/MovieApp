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
    val similarMovies: List<Movie>,
    val backdrop: Backdrop,
    val logo: Logo
)