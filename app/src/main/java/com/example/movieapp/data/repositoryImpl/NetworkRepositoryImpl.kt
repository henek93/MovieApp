package com.example.movieapp.data.repositoryImpl

import android.util.Log
import com.example.movieapp.data.mapper.DtoMapper
import com.example.movieapp.data.network.api.ApiFactory
import com.example.movieapp.domain.enteties.Actor
import com.example.movieapp.domain.networkRepository.NetworkRepository
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.Trailer
import java.lang.Error

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
            genreName = genreName,
            page = page,
            limit = limit
        )
        if (response.isSuccessful) {
            response.body()?.let {
                Log.d("NeteworkRepositoryImpl", it.docs.toString())
                return mapper.mapListMovieDtoMovie(it.docs)
            }
            Log.d("NeteworkRepositoryImpl", response.message())
        }
        throw RuntimeException("Ошибка в получение данных по жанру ${genreName} ")
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

    override suspend fun getActor(actorId: Int): Actor {
        TODO("Not yet implemented")
    }


}