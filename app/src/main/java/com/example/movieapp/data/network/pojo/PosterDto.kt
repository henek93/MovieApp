package com.example.movieappkotlin.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PosterDto(
    @SerializedName("url")
    val url: String
): Serializable
