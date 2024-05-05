package com.example.movieapp.domain.useCases.databaseUseCases

import com.example.movieapp.domain.dataBaseRepository.DatabaseRepository
import javax.inject.Inject

class GetMovieFromDbUseCase @Inject constructor(
    private val repository: DatabaseRepository
){

    suspend fun getMovieFromDb(movieId: Int) = repository.getMovie(movieId)
}