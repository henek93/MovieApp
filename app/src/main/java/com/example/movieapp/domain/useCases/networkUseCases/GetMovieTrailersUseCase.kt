package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository
import javax.inject.Inject

class GetMovieTrailersUseCase @Inject constructor(
    private val repository: NetworkRepository
) {

    suspend fun getMovieTrailers(movieId: Int) = repository.getMoviesTrailers(movieId)
}