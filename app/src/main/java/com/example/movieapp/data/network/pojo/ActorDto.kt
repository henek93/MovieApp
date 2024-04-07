package com.example.movieapp.data.network.pojo

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ActorDto(

    @SerializedName("id")
    @Expose
    @PrimaryKey
    val id: Int,

    @SerializedName("photo")
    @Expose
    val photoUrl: String? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("description")
    @Expose
    val description: String? = null
)