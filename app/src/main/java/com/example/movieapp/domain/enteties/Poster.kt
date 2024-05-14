package com.example.movieapp.domain.enteties

import java.io.Serializable

data class Poster(
    val url: String = ""
): Serializable {

    companion object{
        const val UNKNOWN_URL = "https://www.riakchr.ru/upload/iblock/39d/uavmacl6tbi2jttr09ah6csd1zlt1bbg.jpg"
    }
}