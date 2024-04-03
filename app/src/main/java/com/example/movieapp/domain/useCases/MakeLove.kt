package com.example.movieapp.domain.useCases

import com.example.movieapp.domain.MovieRepository
import javax.inject.Inject

class MakeLove @Inject constructor(
    private val repository: MovieRepository
) {

    suspend fun makeLove() {
        repository.makeLove()
    }
}