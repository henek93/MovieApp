package com.example.movieappkotlin.pojo

import androidx.room.PrimaryKey
import com.example.movieapp.data.network.pojo.ActorDto
import com.example.movieapp.data.network.pojo.BackdropDto
import com.example.movieapp.data.network.pojo.CountriesDto
import com.example.movieapp.data.network.pojo.GenreDto
import com.example.movieapp.data.network.pojo.LogoDto
import com.example.movieapp.data.network.pojo.SimilarMovieDto
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
    val name: String?,

    @SerializedName("rating")
    @Expose
    val rating: RatinggDto,

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("year")
    @Expose
    val year: Int?,

    @SerializedName("poster")
    @Expose
    val poster: PosterDto,

    @SerializedName("ageRaiting")
    @Expose
    val pgRating: Int?,

    @SerializedName("type")
    @Expose
    val type: String?,

    @SerializedName("type")
    @Expose
    val genres: List<GenreDto>,

    @SerializedName("type")
    @Expose
    val countries: List<CountriesDto>,

    @SerializedName("type")
    @Expose
    val actors: List<ActorDto>,

    @SerializedName("type")
    @Expose
    val similarMovies: List<SimilarMovieDto>,

    @SerializedName("backdrop")
    @Expose
    val backdrop: BackdropDto,

    @SerializedName("type")
    @Expose
    val logo: LogoDto
): Serializable


