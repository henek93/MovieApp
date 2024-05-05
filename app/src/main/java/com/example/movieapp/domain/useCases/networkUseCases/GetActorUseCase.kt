package com.example.movieapp.domain.useCases.networkUseCases

import com.example.movieapp.domain.networkRepository.NetworkRepository
import javax.inject.Inject

class GetActorUseCase @Inject constructor(
    private val repository: NetworkRepository
){

    suspend fun getActor(actorId: Int) = repository.getActor(actorId)
}