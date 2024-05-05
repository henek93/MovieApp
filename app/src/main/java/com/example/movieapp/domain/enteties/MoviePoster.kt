package com.example.movieapp.domain.enteties

import java.io.Serializable

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
): Serializable