package com.example.movieappkotlin.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RatinggDto(
    @SerializedName("kp")
    val ratingKinoPoisk: Double
): Serializable