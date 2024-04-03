package com.example.movieapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.data.network.api.ApiService
import com.example.movieapp.domain.MovieRepository
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.Poster
import com.example.movieapp.domain.enteties.Raiting
import com.example.movieappkotlin.pojo.MovieDto
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: MovieMapper
): MovieRepository{


    override suspend fun getMovie(movieId: Int): Movie {
        TODO("Not yet implemented")
    }


    override suspend fun getPoster(movieId: Int): Poster {
        TODO("Not yet implemented")
    }

    override suspend fun getRaiting(movieId: Int): Raiting {
        TODO("Not yet implemented")
    }

    override fun getListMovie(): LiveData<Movie> {
        TODO("Not yet implemented")
    }


    override suspend fun makeLove() {
        TODO("Not yet implemented")
    }


}