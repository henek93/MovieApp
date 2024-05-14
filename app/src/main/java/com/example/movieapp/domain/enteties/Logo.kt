package com.example.movieapp.domain.enteties

import java.io.Serializable

data class Logo(
    val url: String = ""
): Serializable {
    companion object{
        const val UNKNOWN_URL = "http://pm1.narvii.com/7098/6123b06e2b6d79b7207e57de08916a22a03a2c66r1-460-460v2_uhq.jpg"
    }
}