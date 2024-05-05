package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository
import javax.inject.Inject

class GetMoviePosterUseCase @Inject constructor(
    private val repository: NetworkRepository
) {

    suspend fun getMoviePoster(movieId: Int) = repository.getMoviePoster(movieId)
}