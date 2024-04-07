package com.example.movieapp.data.network.api

import androidx.lifecycle.LiveData
import com.example.movieappkotlin.pojo.MovieSourceDto
import com.example.movieappkotlin.pojo.VideosDto
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("v1.3/movie?token=JVB0KRX-ATF4T6E-J5RA425-Z2NDQS1&field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1&limit=10")
    suspend fun getListMovies(@Query("page") page: Int): Response<MovieSourceDto>

    @GET("v1.3/movie/{id}?token=HSDF43E-YJH4D72-NQ89AHR-36KDFV3")
    suspend fun getMoviesTrailers(@Path("id") id:Int): Response<VideosDto>
}