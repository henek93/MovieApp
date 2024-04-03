package com.example.movieappkotlin.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "Favourit_movies")
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
    val poster: PosterDto? = null
    ): Serializable
