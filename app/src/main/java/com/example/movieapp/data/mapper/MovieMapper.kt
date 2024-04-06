package com.example.movieapp.data.mapper

import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.Poster
import com.example.movieapp.domain.enteties.Raiting
import com.example.movieappkotlin.pojo.MovieDto
import com.example.movieappkotlin.pojo.PosterDto
import com.example.movieappkotlin.pojo.RatinggDto
import javax.inject.Inject

class MovieMapper{

    fun mapMovieDtoMovie(movieDto: MovieDto) = Movie(
        id = movieDto.id,
        name = movieDto.name ?: "",
        description = movieDto.description ?: "",
        poster = mapPosterDtoPoster(movieDto.poster  ?: PosterDto("")),
        isFavourite = false,
        raiting = mapRaitingDtoRaiting(movieDto.rating ?: RatinggDto(0.0))
    )

    fun mapPosterDtoPoster(posterDto: PosterDto) = Poster(
        url = posterDto.url
    )

    fun mapRaitingDtoRaiting(raitingDto: RatinggDto) = Raiting(
        raiting = raitingDto.ratingKinoPoisk
    )

    fun mapListMovieDtoMovie(listMovieDto: List<MovieDto>) = listMovieDto.map {
        mapMovieDtoMovie(it)
    }
}