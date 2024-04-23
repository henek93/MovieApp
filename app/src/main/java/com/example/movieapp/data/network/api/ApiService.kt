package com.example.movieapp.data.network.api

import com.example.movieapp.data.network.pojo.ActorDto
import com.example.movieapp.data.network.pojo.MoviePosterDto
import com.example.movieappkotlin.pojo.MovieDto
import com.example.movieappkotlin.pojo.MovieSourceDto
import com.example.movieappkotlin.pojo.VideosDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("v1.4/movie?token=${ApiFactory.TOKEN}&field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1&limit=10")
    suspend fun getListMovies(@Query("page") page: Int): Response<MovieSourceDto>

    @GET("v1.4/movie/{id}?token=HSDF43E-YJH4D72-NQ89AHR-36KDFV3")
    suspend fun getMoviesTrailers(@Path("id") id:Int): Response<VideosDto>

    @GET("v1.4/movie?token=${ApiFactory.TOKEN}&selectFields=id&selectFields=name&selectFields=rating&selectFields=description&selectFields=year&selectFields=poster&selectFields=ageRating&selectFields=type&selectFields=genres&selectFields=countries&selectFields=persons&selectFields=similarMovies&selectFields=backdrop&selectFields=logo&sortField=rating.kp&sortType=-1&notNullFields=description&notNullFields=poster.url&notNullFields=backdrop.url&notNullFields=logo.url&selectField=persons")
    suspend fun getListNewMovies(@Query("page") page: Int,
                                @Query("limit") limit: Int): Response<MovieSourceDto>

    @GET("v1.4/movie?token=${ApiFactory.TOKEN}&selectFields=id&selectFields=name&selectFields=rating&selectFields=description&selectFields=year&selectFields=poster&selectFields=ageRating&selectFields=type&selectFields=genres&selectFields=countries&selectFields=persons&selectFields=similarMovies&selectFields=backdrop&selectFields=logo&sortField=rating.kp&sortType=-1&notNullFields=description&notNullFields=poster.url&notNullFields=backdrop.url&notNullFields=logo.url&selectField=persons")
    suspend fun getListMoviesWithGenre(
        @Query("genres.name") genreName: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int): Response<MovieSourceDto>

    @GET("v1.4/movie?token=${ApiFactory.TOKEN}&selectFields=id&selectFields=name&selectFields=rating&selectFields=description&selectFields=year&selectFields=poster&selectFields=ageRating&selectFields=type&selectFields=genres&selectFields=countries&selectFields=persons&selectFields=similarMovies&selectFields=backdrop&selectFields=logo&sortField=rating.kp&sortType=-1&selectField=persons")
    suspend fun getTopListMovies(
        @Query("lists") lists: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int): Response<MovieSourceDto>

    @GET("v1.4/movie/{id}?token=${ApiFactory.TOKEN}")
    suspend fun getMovie(@Path("id") id: Int): Response<MovieDto>

    @GET("v1.4/person/{id}?token=${ApiFactory.TOKEN}")
    suspend fun getActor(@Path("id") actorId: Int): Response<ActorDto>

    @GET("v1.4/movie/{id}?token=${ApiFactory.TOKEN}")
    suspend fun getMoviePoster(@Path("id") id: Int): Response<MoviePosterDto>

    @GET("v1.4/movie/search?token=${ApiFactory.TOKEN}&page=1&limit=30")
    suspend fun getListMoviePosterByName(@Query("query") name: String): Response<List<MoviePosterDto>>

}