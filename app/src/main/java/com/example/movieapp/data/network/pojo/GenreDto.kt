package com.example.movieapp.data.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GenreDto (

    @SerializedName("name")
    @Expose
    val name: String? = null
    )