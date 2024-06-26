package com.example.movieappkotlin.pojo

import androidx.room.PrimaryKey
import com.example.movieapp.data.network.pojo.ActorDto
import com.example.movieapp.data.network.pojo.ActorPosterDto
import com.example.movieapp.data.network.pojo.BackdropDto
import com.example.movieapp.data.network.pojo.CountriesDto
import com.example.movieapp.data.network.pojo.GenreDto
import com.example.movieapp.data.network.pojo.LogoDto
import com.example.movieapp.data.network.pojo.MoviePosterDto
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

    @SerializedName("ageRating")
    @Expose
    val pgRating: Int?,

    @SerializedName("type")
    @Expose
    val type: String?,

    @SerializedName("genres")
    @Expose
    val genres: List<GenreDto>,

    @SerializedName("countries")
    @Expose
    val countries: List<CountriesDto>,

    @SerializedName("persons")
    @Expose
    val actors: List<ActorPosterDto>,

    @SerializedName("similarMovies")
    @Expose
    val similarMovies: List<SimilarMovieDto>,

    @SerializedName("backdrop")
    @Expose
    val backdrop: BackdropDto,

    @SerializedName("logo")
    @Expose
    val logo: LogoDto
): Serializable


