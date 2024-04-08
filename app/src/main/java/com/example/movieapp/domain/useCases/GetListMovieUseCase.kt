package com.example.movieapp.domain.useCases

import com.example.movieapp.domain.MovieRepository
import com.example.movieapp.domain.enteties.Movie
import javax.inject.Inject

class GetListMovieUseCase constructor(
    private val repository: MovieRepository
) {

    suspend fun getListMovie(page: Int) = repository.getListMovie(page)
}