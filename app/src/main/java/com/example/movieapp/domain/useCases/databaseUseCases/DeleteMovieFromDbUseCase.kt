package com.example.movieapp.domain.useCases.databaseUseCases

import com.example.movieapp.domain.dataBaseRepository.DatabaseRepository
import javax.inject.Inject

class DeleteMovieFromDbUseCase @Inject constructor(
    private val repository: DatabaseRepository
) {

    suspend fun deleteMovieFromDb(movieId: Int){
        repository.deleteMovieFromDb(movieId)
    }
}