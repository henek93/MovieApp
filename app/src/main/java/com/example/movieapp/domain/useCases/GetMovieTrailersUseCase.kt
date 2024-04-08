package com.example.movieapp.domain.useCases

import com.example.movieapp.domain.MovieRepository

class GetMovieTrailersUseCase(
    private val repository: MovieRepository
) {

    suspend fun getMovieTrailers(movieId: Int) = repository.getMoviesTrailers(movieId)
}