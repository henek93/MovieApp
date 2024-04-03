package com.example.movieappkotlin.pojo

import com.google.gson.annotations.SerializedName

data class MovieSourceDto(

    @SerializedName("docs")
    val docs: List<MovieDto>
)
