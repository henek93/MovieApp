package com.example.movieapp.data.database

import androidx.room.TypeConverter
import com.example.movieapp.domain.enteties.ActorPoster
import com.example.movieapp.domain.enteties.Backdrop
import com.example.movieapp.domain.enteties.Countries
import com.example.movieapp.domain.enteties.Genre
import com.example.movieapp.domain.enteties.Logo
import com.example.movieapp.domain.enteties.Poster
import com.example.movieapp.domain.enteties.Rating
import com.example.movieapp.domain.enteties.SimilarMovie

class Converters {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromRatting(value: Rating) = value.rating


        @TypeConverter
        @JvmStatic
        fun toRatting(value: Double) = Rating(value)

        @TypeConverter
        @JvmStatic
        fun fromPoster(value: Poster) = value.url


        @TypeConverter
        @JvmStatic
        fun toPoster(value: String) = Poster(value)

        @TypeConverter
        @JvmStatic
        fun fromGenre(value: List<Genre>) = value.map { it.name }.joinToString(",")

        @TypeConverter
        @JvmStatic
        fun toListGenre(value: String) = value.split(",").map { Genre(it) }

        @TypeConverter
        @JvmStatic
        fun fromListCountries(value: List<Countries>) = value.map { it.name }.joinToString(",")

        @TypeConverter
        @JvmStatic
        fun toCountries(value: String) = value.split(",").map { Countries(it) }

        @TypeConverter
        @JvmStatic
        fun fromListActorPoster(value: List<ActorPoster>) = value.map {
            "${it.id}&${it.photoUrl}&${it.name}"
        }.joinToString(",")

        @TypeConverter
        @JvmStatic
        fun inActorPoster(value: String) = value.split(",")
            .map {
                ActorPoster(
                    it.split("&")[0].toInt(),
                    it.split("&")[2],
                    it.split("&")[3]
                )
            }

        @TypeConverter
        @JvmStatic
        fun fromListSimilarMovie(value: List<SimilarMovie>) = value.map {
            "${it.id}&${it.name}&${it.poster.url}&${it.rating.rating}"
        }.joinToString(",")


        @TypeConverter
        @JvmStatic
        fun inListSimilarMovie(value: String) = value.split(",")
            .map {
                SimilarMovie(
                    it.split("&")[1].toInt(),
                    it.split("&")[2],
                    Poster(it.split("&")[3]),
                    Rating(it.split("&")[4].toDouble())
                )
            }


        @TypeConverter
        @JvmStatic
        fun fromBackdrop(value: Backdrop) = "${value.url},${value.previewUrl}"

        @TypeConverter
        @JvmStatic
        fun inBackdrop(value: String): Backdrop {
            val list = value.split(",")

            return Backdrop(list[1], list[2])
        }

        @TypeConverter
        @JvmStatic
        fun fromLogo(value: Logo) = value.url

        @TypeConverter
        @JvmStatic
        fun inLogo(value: String) = Logo(value)
    }
}