package com.example.movieapp.domain.useCases.databaseUseCases

import com.example.movieapp.domain.dataBaseRepository.DatabaseRepository
import com.example.movieapp.domain.enteties.Movie
import javax.inject.Inject

class AddMovieToDbUseCase @Inject constructor(
    private val repository: DatabaseRepository
) {

    suspend fun addMovieToDb(movie: Movie) = repository.addMovieToDb(movie)

}