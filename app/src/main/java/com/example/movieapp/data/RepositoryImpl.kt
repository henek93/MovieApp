package com.example.movieapp.data

import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.data.network.api.ApiFactory
import com.example.movieapp.domain.MovieRepository
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.Poster
import com.example.movieapp.domain.enteties.Rating
import java.lang.RuntimeException

class RepositoryImpl: MovieRepository {

    private val apiService = ApiFactory.apiService
    private val mapper = MovieMapper()

    override suspend fun getMovie(movieId: Int): Movie {
        TODO("Not yet implemented")
    }


    override suspend fun getPoster(movieId: Int): Poster {
        TODO("Not yet implemented")
    }

    override suspend fun getRaiting(movieId: Int): Rating {
        TODO("Not yet implemented")
    }

    override suspend fun getListMovie(page: Int, listOld: List<Movie>?): List<Movie>{
        val response = apiService.getListMovies(page)

        if (response.isSuccessful){
            response.body()?.let {
                return mapper.mapListMovieDtoMovie(it.docs)
            }
        }
        throw RuntimeException("excaprion in repositoryImpl with response")
    }


    override suspend fun makeLove() {
        TODO("Not yet implemented")
    }


}