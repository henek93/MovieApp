package com.example.movieapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieToDb(movieDbModel: MovieDbModel)

    @Query("DELETE FROM favouriteMovies WHERE id=:movieId")
    suspend fun deleteMovieFromDb(movieId: Int)

    @Query("SELECT * FROM favouriteMovies")
    fun getListMovieFromDb(): LiveData<List<MovieDbModel>>

    @Query("SELECT * FROM favouriteMovies WHERE id=:movieId LIMIT 1")
    suspend fun getMovieFromDb(movieId: Int): MovieDbModel?

    @Query("DELETE FROM favouriteMovies")
    suspend fun deleteMoviesFromDb()
}