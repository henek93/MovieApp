package com.example.movieapp.domain.enteties

import java.io.Serializable

data class Countries(
    val name: String = ""
): Serializable {

    companion object{
        const val UNKNOWN_NAME = "Неизвестна страна"
    }
}