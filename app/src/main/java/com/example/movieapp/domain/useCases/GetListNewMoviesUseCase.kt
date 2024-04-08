package com.example.movieapp.domain.useCases

import com.example.movieapp.domain.MovieRepository

class GetListNewMoviesUseCase(
    private val repository: MovieRepository
) {

    suspend fun getTopNewMovies(page: Int, limit: Int) = repository.getListNewMovies(page, limit)
}