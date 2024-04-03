package com.example.movieappkotlin.pojo

import com.google.gson.annotations.SerializedName

data class VideosDto (
    @SerializedName("videos")
    val trailerListDto: TrailerListDto
)