package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository

class GetMovieTrailersUseCase(
    private val repository: NetworkRepository
) {

    suspend fun getMovieTrailers(movieId: Int) = repository.getMoviesTrailers(movieId)
}