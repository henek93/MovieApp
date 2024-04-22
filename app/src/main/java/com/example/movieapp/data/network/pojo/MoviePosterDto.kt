package com.example.movieapp.data.network.pojo

import androidx.room.PrimaryKey
import com.example.movieappkotlin.pojo.PosterDto
import com.example.movieappkotlin.pojo.RatinggDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MoviePosterDto(
    @SerializedName("id")
    @Expose
    @PrimaryKey
    val id: Int,

    @SerializedName("name")
    @Expose
    val name: String?,

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("rating")
    @Expose
    val rating: RatinggDto,
    @SerializedName("poster")
    @Expose
    val poster: PosterDto,

    @SerializedName("ageRating")
    @Expose
    val pgRating: Int?,
    @SerializedName("backdrop")
    @Expose
    val backdrop: BackdropDto?,

    @SerializedName("logo")
    @Expose
    val logo: LogoDto?
): Serializable