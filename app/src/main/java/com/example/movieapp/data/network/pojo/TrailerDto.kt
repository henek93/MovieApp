package com.example.movieappkotlin.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class TrailerDto(

    @SerializedName("url")
    @Expose
    val url: String? = null,
    @SerializedName("name")
    @Expose
    val name: String? = null,
)