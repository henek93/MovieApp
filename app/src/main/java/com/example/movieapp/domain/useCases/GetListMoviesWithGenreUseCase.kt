package com.example.movieapp.domain.useCases

import com.example.movieapp.domain.MovieRepository

class GetListMoviesWithGenreUseCase(
    private val repository: MovieRepository
) {

    suspend fun getTopMoviesWithGenre(genreName: String, page: Int, limit: Int) =
        repository.getListMoviesWithGenre(genreName, page, limit)
}