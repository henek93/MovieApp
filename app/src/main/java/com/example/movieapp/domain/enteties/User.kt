package com.example.movieapp.domain.enteties

import java.io.Serializable

data class User(
    val id: String = "",
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val listFavouriteMovies: List<Movie>? = null
): Serializable