package com.example.movieapp.domain.enteties

import java.io.Serializable

data class ActorPoster(
    val id: Int,
    val photoUrl: String,
    val name: String,
): Serializable