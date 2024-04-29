package com.example.movieapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieapp.domain.enteties.ActorPoster
import com.example.movieapp.domain.enteties.Backdrop
import com.example.movieapp.domain.enteties.Countries
import com.example.movieapp.domain.enteties.Genre
import com.example.movieapp.domain.enteties.Logo
import com.example.movieapp.domain.enteties.Poster
import com.example.movieapp.domain.enteties.Rating
import com.example.movieapp.domain.enteties.SimilarMovie

@Entity(tableName = "favouriteMovies")
data class MovieDbModel(
    @PrimaryKey
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
)