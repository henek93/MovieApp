package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository
import javax.inject.Inject

class GetListMoviePostersByNameUseCase @Inject constructor(
    private val repository: NetworkRepository
) {

    suspend fun getListMoviePosterByName(name: String) = repository.getListMoviePosterByName(name)
}