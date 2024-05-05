package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository
import javax.inject.Inject

class GetTopListMoviesUseCase @Inject constructor(
    private val repository: NetworkRepository
) {

    suspend fun getTopListMovies(list: String, page: Int, limit: Int) =
        repository.getTopListMovies(list, page, limit)
}