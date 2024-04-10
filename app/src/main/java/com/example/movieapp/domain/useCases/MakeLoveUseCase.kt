package com.example.movieapp.domain.useCases

import com.example.movieapp.domain.networkRepository.NetworkRepository
import javax.inject.Inject

class MakeLoveUseCase @Inject constructor(
    private val repository: NetworkRepository
) {

    suspend fun makeLove() {
        repository.makeLove()
    }
}