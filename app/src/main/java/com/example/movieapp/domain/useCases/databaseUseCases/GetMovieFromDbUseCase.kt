package com.example.movieapp.domain.useCases.databaseUseCases

import com.example.movieapp.domain.dataBaseRepository.DatabaseRepository

class GetMovieFromDbUseCase(
    private val repository: DatabaseRepository
){

    suspend fun getMovieFromDb(movieId: Int) = repository.getMovie(movieId)
}