package com.example.movieapp.domain.enteties

data class Movie(
    val id: Int,
    val name: String,
    val description: String,
    val poster: Poster,
    val raiting: Raiting,
    val isFavourite: Boolean,
)