package com.example.movieapp.domain.enteties

data class Poster(
    val url: String
){

    companion object{
        const val UNKNOWN_URL = "https://wcinema.ru/upload/000/u18/4/d/079ae886.jpg"
    }
}