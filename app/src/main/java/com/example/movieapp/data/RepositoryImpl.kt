package com.example.movieapp.data

import com.example.movieapp.data.mapper.MovieMapper
import com.example.movieapp.data.network.api.ApiFactory
import com.example.movieapp.domain.MovieRepository
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.Trailer

class RepositoryImpl: MovieRepository {

    private val apiService = ApiFactory.apiService
    private val mapper = MovieMapper()

    override suspend fun getMovie(movieId: Int): Movie {
        TODO("Not yet implemented")
    }


    override suspend fun getListMovie(page: Int): List<Movie>{
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

    override suspend fun getMoviesTrailers(id: Int): List<Trailer> {
        TODO("Not yet implemented")
    }

    override suspend fun getListNewMovies(page: Int, limit: Int): List<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun getListMoviesWithGenre(
        genreName: String,
        page: Int,
        limit: Int
    ): List<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopListMovies(list: String, page: Int, limit: Int): List<Movie> {
        val response =
            apiService.getTopListMovies(
                list,
                page,
                limit)

        if (response.isSuccessful){
            response.body()?.let {
                return mapper.mapListMovieDtoMovie(it.docs)
            }
        }
        throw RuntimeException("excaprion in repositoryImpl with response")
    }


}