package com.example.movieapp.domain.enteties

data class MoviePoster(
    val id: Int,
    val name: String,
    val poster: Poster,
    val description: String,
    val rating: Rating,
    val isFavourite: Boolean,
    val pgRating: Int,
    val backdrop: Backdrop,
    val logo: Logo
)