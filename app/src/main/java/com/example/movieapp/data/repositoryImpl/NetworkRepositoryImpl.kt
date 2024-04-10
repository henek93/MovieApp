package com.example.movieapp.data.repositoryImpl

import com.example.movieapp.data.mapper.DtoMapper
import com.example.movieapp.data.network.api.ApiFactory
import com.example.movieapp.domain.networkRepository.NetworkRepository
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.Trailer

class NetworkRepositoryImpl : NetworkRepository {

    private val apiService = ApiFactory.apiService
    private val mapper = DtoMapper()

    override suspend fun getMovie(movieId: Int): Movie {
        val response = apiService.getMovie(movieId)

        if (response.isSuccessful){
            response.body()?.let {
                return mapper.mapMovieDtoMovie(it)
            }
        }
        throw RuntimeException("Ошибка в получениии данных о фильме")
    }

    override suspend fun getMoviesTrailers(id: Int): List<Trailer> {
        val response = apiService.getMoviesTrailers(id)

        if (response.isSuccessful){
            response.body()?.let {
                mapper.mapListTrailerDtoTrailer(it.trailerListDto.trailerDtos)
            }
        }
        throw RuntimeException("Ошибка в получении трейлеров")
    }

    override suspend fun getListNewMovies(page: Int, limit: Int): List<Movie> {
        val response = apiService.getListNewMovies(
            page,
            limit
        )

        if (response.isSuccessful){
            response.body()?.let {
                 return mapper.mapListMovieDtoMovie(it.docs)
            }
        }
        throw RuntimeException("Ошибка в получение данных по новым фильмам")
    }

    override suspend fun getListMoviesWithGenre(
        genreName: String,
        page: Int,
        limit: Int
    ): List<Movie> {
        val response = apiService.getListMoviesWithGenre(
            genreName,
            page,
            limit
        )
        if (response.isSuccessful) {
            response.body()?.let {
                return mapper.mapListMovieDtoMovie(it.docs)
            }
        }
        throw RuntimeException("Ошибка в получение данных по жанру")
    }

    override suspend fun getTopListMovies(list: String, page: Int, limit: Int): List<Movie> {
        val response =
            apiService.getTopListMovies(
                list,
                page,
                limit
            )

        if (response.isSuccessful) {
            response.body()?.let {
                return mapper.mapListMovieDtoMovie(it.docs)
            }
        }
        throw RuntimeException("excaprion in repositoryImpl with response")
    }


}