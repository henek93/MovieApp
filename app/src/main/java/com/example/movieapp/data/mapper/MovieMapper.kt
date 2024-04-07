package com.example.movieapp.data.mapper

import com.example.movieapp.data.network.pojo.ActorDto
import com.example.movieapp.data.network.pojo.BackdropDto
import com.example.movieapp.data.network.pojo.CountriesDto
import com.example.movieapp.data.network.pojo.GenreDto
import com.example.movieapp.data.network.pojo.LogoDto
import com.example.movieapp.data.network.pojo.SimilarMovieDto
import com.example.movieapp.domain.enteties.Actor
import com.example.movieapp.domain.enteties.Backdrop
import com.example.movieapp.domain.enteties.Countries
import com.example.movieapp.domain.enteties.Genre
import com.example.movieapp.domain.enteties.Logo
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.Poster
import com.example.movieapp.domain.enteties.Rating
import com.example.movieapp.domain.enteties.SimilarMovie
import com.example.movieappkotlin.pojo.MovieDto
import com.example.movieappkotlin.pojo.PosterDto
import com.example.movieappkotlin.pojo.RatinggDto

class MovieMapper{

    fun mapMovieDtoMovie(movieDto: MovieDto) = Movie(
        id = movieDto.id,
        name = movieDto.name ?: Movie.UNKNOWN_NAME,
        description = movieDto.description ?: Movie.UNKNOWN_DESCRIPTION,
        poster = mapPosterDtoPoster(movieDto.poster),
        isFavourite = false,
        rating = mapRaitingDtoRaiting(movieDto.rating),
        pgRating = movieDto.pgRating ?: Movie.UNKNOWN_PG_RATING,
        type = movieDto.type ?: Movie.UNKNOWN_TYPE,
        genres = mapListGenreDtoGener(movieDto.genres),
        countries = mapListCountriesDtoCountries(movieDto.countries),
        actors = mapListActorsDtoActors(movieDto.actors),
        similarMovies = mapListSimilarMovieDtoSimilarMovie(movieDto.similarMovies),
        backdrop = mapBackdropDtoBackDrop(movieDto.backdrop),
        logo = mapLogoDtoLogo(movieDto.logo)
    )

    fun mapLogoDtoLogo(logoDto: LogoDto) = Logo(
        url = logoDto.url ?: Logo.UNKNOWN_URL
    )

    fun mapBackdropDtoBackDrop(backdropDto: BackdropDto) = Backdrop(
        url = backdropDto.url ?: Backdrop.UNKNOWN_PHOTO,
        previewUrl = backdropDto.previewUrl ?: Backdrop.UNKNOWN_PREVIEW_URL
    )


    fun mapListActorsDtoActors(listActorsDto: List<ActorDto>) = listActorsDto.map {
        mapActorsDtoActors(it)
    }

    fun mapActorsDtoActors(actorDto: ActorDto) = Actor(
        id = actorDto.id,
        photoUrl = actorDto.photoUrl ?: Actor.UNKNOWN_PHOTO,
        description = actorDto.description ?: Actor.UNKNOWN_DESCRIPTION,
        name = actorDto.name ?: Actor.UNKNOWN_NAME
    )

    fun mapListCountriesDtoCountries(listCountriesDto: List<CountriesDto>) = listCountriesDto.map {
        mapCountriesDtoCountries(it)
    }

    fun mapCountriesDtoCountries(countriesDto: CountriesDto) = Countries(
        name = countriesDto.name ?: Countries.UNKNOWN_NAME
    )

    fun mapPosterDtoPoster(posterDto: PosterDto) = Poster(
        url = posterDto.url ?: Poster.UNKNOWN_URL
    )

    fun mapRaitingDtoRaiting(ratingDto: RatinggDto) = Rating(
        rating = ratingDto.ratingKinoPoisk ?: Rating.UNKNOWN_RATING
    )

    fun mapListMovieDtoMovie(listMovieDto: List<MovieDto>) = listMovieDto.map {
        mapMovieDtoMovie(it)
    }

    fun mapListSimilarMovieDtoSimilarMovie(listSimilarMovieDto: List<SimilarMovieDto>) = listSimilarMovieDto.map {
        mapSimilarMovieDtoSimilarMovie(it)
    }

    fun mapSimilarMovieDtoSimilarMovie(similarMovieDto: SimilarMovieDto) = SimilarMovie(
        id = similarMovieDto.id,
        name = similarMovieDto.name ?: SimilarMovie.UNKNOWN_NAME,
        poster = mapPosterDtoPoster(similarMovieDto.poster),
        rating = mapRaitingDtoRaiting(similarMovieDto.rating)
    )

    fun mapListGenreDtoGener(listGenreDto: List<GenreDto>) = listGenreDto.map {
        mapGenreDtoGenre(it)
    }

    private fun mapGenreDtoGenre(genreDto: GenreDto) = Genre(
        name = genreDto.name ?: Genre.UNKNOWN_NAME
    )
}