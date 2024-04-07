package com.example.movieappkotlin.pojo

import androidx.room.PrimaryKey
import com.example.movieapp.data.network.pojo.ActorDto
import com.example.movieapp.data.network.pojo.BackdropDto
import com.example.movieapp.data.network.pojo.CountriesDto
import com.example.movieapp.data.network.pojo.GenreDto
import com.example.movieapp.data.network.pojo.LogoDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDto(
    @SerializedName("id")
    @Expose
    @PrimaryKey
    val id: Int,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("rating")
    @Expose
    val rating: RatinggDto? = null,

    @SerializedName("description")
    @Expose
    val description: String? = null,

    @SerializedName("year")
    @Expose
    val year: Int? = null,

    @SerializedName("poster")
    @Expose
    val poster: PosterDto? = null,

    @SerializedName("ageRaiting")
    @Expose
    val pgRating: Int? = null,

    @SerializedName("type")
    @Expose
    val type: String? = null,

    @SerializedName("type")
    @Expose
    val genres: List<GenreDto>? = null,

    @SerializedName("type")
    @Expose
    val countries: List<CountriesDto>? = null,

    @SerializedName("type")
    @Expose
    val actors: List<ActorDto>? = null,

    @SerializedName("type")
    @Expose
    val similarMovies: List<MovieDto>? = null,

    @SerializedName("backdrop")
    @Expose
    val backdrop: BackdropDto? = null,

    @SerializedName("type")
    @Expose
    val logo: LogoDto? = null
): Serializable


