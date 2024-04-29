package com.example.movieapp.domain.dataBaseRepository

import androidx.lifecycle.LiveData
import com.example.movieapp.domain.enteties.Movie

interface DatabaseRepository {

    fun getListFavouriteMovie(): LiveData<List<Movie>>

    suspend fun getMovie(movieId: Int): Movie

    suspend fun deleteMovieFromDb(movieId: Int)

    suspend fun addMovieToDb(movie: Movie)
}