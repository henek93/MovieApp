package com.example.movieapp.data.repositoryImpl

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import com.example.movieapp.data.database.MovieDatabase
import com.example.movieapp.data.mapper.DbMapper
import com.example.movieapp.domain.dataBaseRepository.DatabaseRepository
import com.example.movieapp.domain.enteties.Movie

class DatabaseRepositoryImpl : DatabaseRepository {

    private val movieDao = MovieDatabase.getInstance(Application()).movieDao()
    private val mapper = DbMapper()

    override fun getListFavouriteMovie() = MediatorLiveData<List<Movie>>().apply {
        addSource(movieDao.getListMovieFromDb()) {
            value = mapper.mapListDbMovieToListMovie(it)
        }
    }

    override suspend fun getMovie(movieId: Int) =
        mapper.mapDbMovieToMovie(movieDao.getMovieFromDb(movieId))

    override suspend fun deleteMovieFromDb(movieId: Int) {
        movieDao.deleteMovieFromDb(movieId)
    }

    override suspend fun addMovieToDb(movie: Movie) {
        movieDao.addMovieToDb(mapper.mapMovieToDbMovie(movie))
    }


}