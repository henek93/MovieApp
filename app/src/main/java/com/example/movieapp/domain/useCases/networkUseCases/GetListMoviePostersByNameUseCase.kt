package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository

class GetListMoviePostersByNameUseCase(
    private val repository: NetworkRepository
) {

    suspend fun getListMoviePosterByName(name: String) = repository.getListMoviePosterByName(name)
}