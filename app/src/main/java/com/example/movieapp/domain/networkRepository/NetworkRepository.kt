package com.example.movieapp.domain.networkRepository

import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.Trailer

interface NetworkRepository {

    suspend fun getMovie(movieId: Int): Movie

    suspend fun getMoviesTrailers(id: Int): List<Trailer>

    suspend fun getListNewMovies(page: Int, limit: Int): List<Movie>

    suspend fun getListMoviesWithGenre(genreName: String, page: Int, limit: Int): List<Movie>

    suspend fun getTopListMovies(list: String, page: Int, limit: Int): List<Movie>
}