package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository

class GetActorUseCase(
    private val repository: NetworkRepository
){

    suspend fun getActor(actorId: Int) = repository.getActor(actorId)
}