package com.example.movieapp.data.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LogoDto(

    @SerializedName("url")
    @Expose
    val url: String? = null
)