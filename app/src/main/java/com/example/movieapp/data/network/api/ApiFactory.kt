package com.example.movieapp.data.network.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val BASE_URL = "https://api.kinopoisk.dev/"

    const val TOKEN = "JVB0KRX-ATF4T6E-J5RA425-Z2NDQS1"


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}