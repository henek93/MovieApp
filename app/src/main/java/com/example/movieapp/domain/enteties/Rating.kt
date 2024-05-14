package com.example.movieapp.domain.enteties

import java.io.Serializable

data class Rating(
    val rating: Double = 0.0
): Serializable {
    companion object{
        const val UNKNOWN_RATING = -10.0
    }
}