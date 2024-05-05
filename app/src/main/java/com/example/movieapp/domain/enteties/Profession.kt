package com.example.movieapp.domain.enteties

import java.io.Serializable

data class Profession(
    val value: String
): Serializable {

    companion object{

        const val UNKNOWN_VALUE = "Нет данных"
    }
}