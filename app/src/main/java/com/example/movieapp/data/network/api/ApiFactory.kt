package com.example.movieapp.data.network.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    const val TOKEN = "JVB0KRX-ATF4T6E-J5RA425-Z2NDQS1"
    const val LIST_TOP_250_NAME = "top250"
    const val GENRE_ADVENTURE = "приключения"


    private val BASE_URL = "https://api.kinopoisk.dev/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}