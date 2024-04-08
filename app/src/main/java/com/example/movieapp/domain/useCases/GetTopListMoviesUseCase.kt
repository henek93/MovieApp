package com.example.movieapp.domain.useCases

import com.example.movieapp.domain.MovieRepository

class GetTopListMoviesUseCase(
    private val repository: MovieRepository
) {

    suspend fun getTopListMovies(list: String, page: Int, limit: Int) =
        repository.getTopListMovies(list, page, limit)
}