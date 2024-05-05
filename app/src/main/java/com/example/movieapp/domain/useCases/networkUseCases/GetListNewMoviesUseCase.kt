package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository
import javax.inject.Inject

class GetListNewMoviesUseCase @Inject constructor(
    private val repository: NetworkRepository
) {

    suspend fun getTopNewMovies(page: Int, limit: Int) = repository.getListNewMovies(page, limit)
}