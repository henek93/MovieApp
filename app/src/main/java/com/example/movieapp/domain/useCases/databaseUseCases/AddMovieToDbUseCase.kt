package com.example.movieapp.domain.useCases.databaseUseCases

import com.example.movieapp.domain.dataBaseRepository.DatabaseRepository
import com.example.movieapp.domain.enteties.Movie

class AddMovieToDbUseCase(
    private val repository: DatabaseRepository
) {

    suspend fun addMovieToDbUseCase(movie: Movie) = repository.addMovieToDb(movie)

}