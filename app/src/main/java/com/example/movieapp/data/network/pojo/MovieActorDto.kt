package com.example.movieapp.data.network.pojo

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieActorDto(
    @SerializedName("id")
    @Expose
    @PrimaryKey
    val id: Int
)