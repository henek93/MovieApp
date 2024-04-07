package com.example.movieapp.domain.enteties

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Trailer(
    val url: String,
    val name: String,
){

    companion object{

        const val UNKNOWN_URL = ""
        const val UNKNOWN_NAME = "Неизвестно название трейлера"
    }
}