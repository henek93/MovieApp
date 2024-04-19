package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository

class GetMoviePosterUseCase(
    private val repository: NetworkRepository
) {

    suspend fun getMoviePoster(movieId: Int) = repository.getMoviePoster(movieId)
}