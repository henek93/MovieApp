package com.example.movieapp.domain.useCases

import com.example.movieapp.domain.MovieRepository
import javax.inject.Inject

class GetPoster @Inject constructor(
    private val repository: MovieRepository
) {

    suspend fun getPoster(movieId: Int) = repository.getPoster(movieId)
}