package com.example.movieapp.data.network.api

import androidx.lifecycle.LiveData
import com.example.movieappkotlin.pojo.MovieDto
import com.example.movieappkotlin.pojo.MovieSourceDto
import com.example.movieappkotlin.pojo.VideosDto
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("v1.4/movie?token=${ApiFactory.TOKEN}&field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1&limit=10")
    suspend fun getListMovies(@Query("page") page: Int): Response<MovieSourceDto>

    @GET("v1.4/movie/{id}?token=HSDF43E-YJH4D72-NQ89AHR-36KDFV3")
    suspend fun getMoviesTrailers(@Path("id") id:Int): Response<VideosDto>

    @GET("v1.4/movie?token=${ApiFactory.TOKEN}&selectFields=id&selectFields=name&selectFields=description&selectFields=shortDescription&selectFields=rating&selectFields=poster&selectFields=ageRating&notNullFields=poster.url&notNullFields=shortDescription&sortField=rating.kp&sortType=-1&type=&status=completed&year=2024&rating.kp=6-10")
    suspend fun getListNewMovies(@Query("page") page: Int,
                                @Query("limit") limit: Int): Response<MovieSourceDto>

    @GET("v1.4/movie?token=${ApiFactory.TOKEN}&selectFields=id&selectFields=name&selectFields=description&selectFields=shortDescription&selectFields=rating&selectFields=poster&selectFields=ageRating&notNullFields=poster.url&sortField=rating.kp&sortType=-1&type=movie&status=completed&year=&rating.kp=7-10")
    suspend fun getListMoviesWithGenre(
        @Query("genres.name") genreName: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int): Response<MovieSourceDto>

    @GET("v1.4/movie?token=${ApiFactory.TOKEN}&selectFields=id&selectFields=name&selectFields=rating&selectFields=description&selectFields=year&selectFields=poster&selectFields=ageRating&selectFields=type&selectFields=genres&selectFields=countries&selectFields=persons&selectFields=similarMovies&selectFields=backdrop&selectFields=logo&sortField=rating.kp&sortType=-1")
    suspend fun getTopListMovies(
        @Query("lists") lists: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int): Response<MovieSourceDto>

    @GET("v1.4/movie/{id}?token=${ApiFactory.TOKEN}")
    suspend fun getMovie(@Path("id") id: Int): Response<MovieDto>
}