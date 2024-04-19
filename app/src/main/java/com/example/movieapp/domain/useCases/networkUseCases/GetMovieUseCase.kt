package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: NetworkRepository
) {

    suspend fun getMovie(movieId: Int) = repository.getMovie(movieId)
}