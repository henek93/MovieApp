package com.example.movieapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert
    suspend fun addMovieToDb(movieDbModel: MovieDbModel)

    @Query("DELETE FROM favouriteMovies WHERE id=:movieId")
    suspend fun deleteMovieFromDb(movieId: Int)

    @Query("SELECT * FROM favouriteMovies")
    fun getListMovieFromDb(): LiveData<List<MovieDbModel>>

    @Query("SELECT * FROM favouriteMovies WHERE id=:movieId")
    suspend fun getMovieFromDb(movieId: Int): MovieDbModel
}