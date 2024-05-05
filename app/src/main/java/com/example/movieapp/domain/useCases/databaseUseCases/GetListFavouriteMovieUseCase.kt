package com.example.movieapp.domain.useCases.databaseUseCases

import com.example.movieapp.domain.dataBaseRepository.DatabaseRepository

class GetListFavouriteMovieUseCase(
    private val repository: DatabaseRepository
) {

    fun getListFavouriteMovie() = repository.getListFavouriteMovie()
}