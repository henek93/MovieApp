package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository

class GetListNewMoviesUseCase(
    private val repository: NetworkRepository
) {

    suspend fun getTopNewMovies(page: Int, limit: Int) = repository.getListNewMovies(page, limit)
}