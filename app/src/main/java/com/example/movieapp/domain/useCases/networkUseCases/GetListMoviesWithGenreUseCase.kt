package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository

class GetListMoviesWithGenreUseCase(
    private val repository: NetworkRepository
) {

    suspend fun getTopMoviesWithGenre(genreName: String, page: Int, limit: Int) =
        repository.getListMoviesWithGenre(genreName, page, limit)
}