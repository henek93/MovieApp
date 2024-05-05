package com.example.movieapp.domain.useCases.databaseUseCases

import com.example.movieapp.domain.dataBaseRepository.DatabaseRepository
import javax.inject.Inject

class GetListFavouriteMovieUseCase @Inject constructor(
    private val repository: DatabaseRepository
) {

    fun getListFavouriteMovie() = repository.getListFavouriteMovie()
}