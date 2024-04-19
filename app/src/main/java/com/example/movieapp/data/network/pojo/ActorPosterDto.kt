package com.example.movieapp.data.network.pojo

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ActorPosterDto(
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
)