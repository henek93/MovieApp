package com.example.movieapp.domain.enteties

import java.io.Serializable

data class Rating(
    val rating: Double
): Serializable {
    companion object{
        const val UNKNOWN_RATING = -10.0
    }
}