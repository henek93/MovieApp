package com.example.movieapp.domain.useCases

import com.example.movieapp.domain.MovieRepository
import javax.inject.Inject

class GetRaiting @Inject constructor(
    private val repository: MovieRepository
) {

    suspend fun getRaiting(movieId: Int) = repository.getRaiting(movieId)
}