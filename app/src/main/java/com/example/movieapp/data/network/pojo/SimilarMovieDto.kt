package com.example.movieapp.data.network.pojo

import androidx.room.PrimaryKey
import com.example.movieappkotlin.pojo.PosterDto
import com.example.movieappkotlin.pojo.RatinggDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SimilarMovieDto(
    @SerializedName("id")
    @Expose
    @PrimaryKey
    val id: Int,

    @SerializedName("name")
    @Expose
    val name: String?,

    @SerializedName("poster")
    @Expose
    val poster: PosterDto,

    @SerializedName("rating")
    @Expose
    val rating: RatinggDto,
)