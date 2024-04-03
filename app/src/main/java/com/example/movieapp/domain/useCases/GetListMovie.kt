package com.example.movieapp.domain.useCases

import com.example.movieapp.domain.MovieRepository
import javax.inject.Inject

class GetListMovie @Inject constructor(
    private val repository: MovieRepository
){

    fun getListMovie() = repository.getListMovie()
}