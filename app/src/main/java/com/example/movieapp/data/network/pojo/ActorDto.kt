package com.example.movieapp.data.network.pojo

import androidx.room.PrimaryKey
import com.example.movieappkotlin.pojo.MovieDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ActorDto(

    @SerializedName("id")
    @Expose
    @PrimaryKey
    val id: Int,

    @SerializedName("photo")
    @Expose
    val photoUrl: String?,

    @SerializedName("name")
    @Expose
    val name: String?,

    @SerializedName("profession")
    @Expose
    val listProfessionDto: ProfessionDto,

    @SerializedName("birthday")
    @Expose
    val birthday: String?,

    @SerializedName("movies")
    @Expose
    val listMovieDto: List<MovieDto>
)