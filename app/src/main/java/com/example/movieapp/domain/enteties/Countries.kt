package com.example.movieapp.domain.enteties

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Countries(
    val name: String
){

    companion object{
        const val UNKNOWN_NAME = "Неизвестна страна"
    }
}