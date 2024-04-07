package com.example.movieapp.data.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BackdropDto(

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("previewUrl")
    @Expose
    val previewUrl: String? = null
)