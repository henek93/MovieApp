package com.example.movieapp.data.repositoryImpl

import android.util.Log
import com.example.movieapp.data.mapper.DtoMapper
import com.example.movieapp.data.network.api.ApiFactory
import com.example.movieapp.domain.enteties.Actor
import com.example.movieapp.domain.enteties.ActorPoster
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.MoviePoster
import com.example.movieapp.domain.enteties.Trailer
import com.example.movieapp.domain.networkRepository.NetworkRepository

class NetworkRepositoryImpl : NetworkRepository {

    private val apiService = ApiFactory.apiService
    private val mapper = DtoMapper()

    override suspend fun getMovie(movieId: Int): Movie {
        val response = apiService.getMovie(movieId)

        if (response.isSuccessful) {
            response.body()?.let {
                return mapper.mapMovieDtoMovie(it)
            }
        }
        throw RuntimeException("Ошибка в получениии данных о фильме")
    }

    override suspend fun getMoviesTrailers(id: Int): List<Trailer> {
        val response = apiService.getMoviesTrailers(id)

        if (response.isSuccessful) {
            response.body()?.let {
                mapper.mapListTrailerDtoTrailer(it.trailerListDto.trailerDtos)
            }
        }
        throw RuntimeException("Ошибка в получении трейлеров")
    }

    override suspend fun getListNewMovies(page: Int, limit: Int): List<MoviePoster> {
        val response = apiService.getListNewMovies(
            page,
            limit
        )

        if (response.isSuccessful) {
            response.body()?.let {
                return mapper.mapListMoviePosterDtoMoviePoster(it.docs)
            }
        }
        throw RuntimeException("Ошибка в получение данных по новым фильмам ${response.message()}")
    }

    override suspend fun getListMoviesWithGenre(
        genreName: String,
        page: Int,
        limit: Int
    ): List<MoviePoster> {
        val response = apiService.getListMoviesWithGenre(
            genreName = genreName,
            page = page,
            limit = limit
        )
        if (response.isSuccessful) {
            response.body()?.let {
                Log.d("NeteworkRepositoryImpl", it.docs.toString())
                return mapper.mapListMoviePosterDtoMoviePoster(it.docs)
            }
            Log.d("NeteworkRepositoryImpl", response.message())
        }
        throw RuntimeException("Ошибка в получение данных по жанру ${genreName} ")
    }

    override suspend fun getTopListMovies(list: String, page: Int, limit: Int): List<MoviePoster> {
        val response =
            apiService.getTopListMovies(
                list,
                page,
                limit
            )

        if (response.isSuccessful) {
            response.body()?.let {
                return mapper.mapListMoviePosterDtoMoviePoster(it.docs)
            }
        }
        throw RuntimeException("excaprion in repositoryImpl with response ${response.message()}")
    }

    override suspend fun getActor(actorId: Int): Actor {
        val response = apiService.getActor(actorId)

        if (response.isSuccessful) {
            response.body()?.let {
                return mapper.mapActorDtoActor(it)
            }
        }
        throw RuntimeException("Exception in get actor retrofit ${response.message()}")
    }

    override suspend fun getMoviePoster(movieId: Int): MoviePoster {
        val response = apiService.getMoviePoster(movieId)

        if (response.isSuccessful){
            response.body()?.let {
                return mapper.mapMoviePosterDtoMoviePoster(it)
            }
        }
        throw RuntimeException("Exception in get movie poster ${response.message()}")
    }

    override suspend fun getListMoviePosterByName(name: String): List<MoviePoster> {
        val response = apiService.getListMoviePosterByName(name)

        if (response.isSuccessful){
            response.body()?.let {
                return mapper.mapListMoviePosterDtoMoviePoster(it.docs)
            }
        }
        throw RuntimeException("Exception in get movie poster ${response.message()}")
    }


}