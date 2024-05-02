package com.example.movieapp.domain.enteties

import java.io.Serializable

data class Trailer(
    val url: String,
    val name: String,
): Serializable {

    companion object{

        const val UNKNOWN_URL = ""
        const val UNKNOWN_NAME = "Неизвестно название трейлера"
    }
}