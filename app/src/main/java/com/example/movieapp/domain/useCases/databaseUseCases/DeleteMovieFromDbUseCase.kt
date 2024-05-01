package com.example.movieapp.domain.useCases.databaseUseCases

import com.example.movieapp.domain.dataBaseRepository.DatabaseRepository

class DeleteMovieFromDbUseCase(
    private val repository: DatabaseRepository
) {

    suspend fun deleteMovieFromDb(movieId: Int){
        repository.deleteMovieFromDb(movieId)
    }
}