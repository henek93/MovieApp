package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository

class GetListMovieUseCase constructor(
    private val repository: NetworkRepository
) {

    suspend fun getListMovie(page: Int) = repository.getListMovie(page)
}