package com.example.movieapp.domain.enteties

data class Rating(
    val rating: Double
){
    companion object{
        const val UNKNOWN_RATING = -10.0
    }
}