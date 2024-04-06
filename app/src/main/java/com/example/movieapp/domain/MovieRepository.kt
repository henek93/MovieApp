package com.example.movieapp.domain

import androidx.lifecycle.LiveData
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.Poster
import com.example.movieapp.domain.enteties.Raiting

interface MovieRepository {

    suspend fun getMovie(movieId: Int): Movie

    suspend fun getPoster(movieId: Int): Poster

    suspend fun getRaiting(movieId: Int): Raiting

    suspend fun getListMovie(page: Int, listOld: List<Movie>?): List<Movie>

    suspend fun makeLove()
}