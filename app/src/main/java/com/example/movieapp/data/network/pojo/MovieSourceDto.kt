package com.example.movieappkotlin.pojo

import com.example.movieapp.data.network.pojo.MoviePosterDto
import com.google.gson.annotations.SerializedName

data class MovieSourceDto(

    @SerializedName("docs")
    val docs: List<MoviePosterDto>
)
