package com.example.movieappkotlin.pojo

import com.google.gson.annotations.SerializedName

data class TrailerListDto (
    @SerializedName("trailers")
    var trailerDtos: List<TrailerDto>
)