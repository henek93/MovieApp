package com.example.movieapp.domain.useCases

import com.example.movieapp.domain.MovieRepository
import javax.inject.Inject

class GetMovie @Inject constructor(
    private val repository: MovieRepository
) {

    suspend fun getMovie(movieId: Int) = repository.getMovie(movieId)
}