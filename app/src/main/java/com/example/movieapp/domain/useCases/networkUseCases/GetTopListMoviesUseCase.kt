package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository

class GetTopListMoviesUseCase(
    private val repository: NetworkRepository
) {

    suspend fun getTopListMovies(list: String, page: Int, limit: Int) =
        repository.getTopListMovies(list, page, limit)
}