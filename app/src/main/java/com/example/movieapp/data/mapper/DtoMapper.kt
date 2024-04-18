package com.example.movieapp.data.mapper

import com.example.movieapp.data.network.pojo.ActorDto
import com.example.movieapp.data.network.pojo.BackdropDto
import com.example.movieapp.data.network.pojo.CountriesDto
import com.example.movieapp.data.network.pojo.GenreDto
import com.example.movieapp.data.network.pojo.LogoDto
import com.example.movieapp.data.network.pojo.MovieActorDto
import com.example.movieapp.data.network.pojo.ProfessionDto
import com.example.movieapp.data.network.pojo.SimilarMovieDto
import com.example.movieapp.domain.enteties.Actor
import com.example.movieapp.domain.enteties.Backdrop
import com.example.movieapp.domain.enteties.Countries
import com.example.movieapp.domain.enteties.Genre
import com.example.movieapp.domain.enteties.Logo
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.MovieActor
import com.example.movieapp.domain.enteties.Poster
import com.example.movieapp.domain.enteties.Profession
import com.example.movieapp.domain.enteties.Rating
import com.example.movieapp.domain.enteties.SimilarMovie
import com.example.movieapp.domain.enteties.Trailer
import com.example.movieappkotlin.pojo.MovieDto
import com.example.movieappkotlin.pojo.PosterDto
import com.example.movieappkotlin.pojo.RatinggDto
import com.example.movieappkotlin.pojo.TrailerDto

class DtoMapper{

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

    fun mapTrailerDtoTrailer(trailerDto: TrailerDto) = Trailer(
        url = trailerDto.url ?: Trailer.UNKNOWN_URL,
        name = trailerDto.name ?: Trailer.UNKNOWN_NAME
    )

    fun mapListTrailerDtoTrailer(list: List<TrailerDto>) = list.map {
        mapTrailerDtoTrailer(it)
    }

    fun mapLogoDtoLogo(logoDto: LogoDto) = Logo(
        url = logoDto.url ?: Logo.UNKNOWN_URL
    )

    fun mapBackdropDtoBackDrop(backdropDto: BackdropDto) = Backdrop(
        url = backdropDto.url ?: Backdrop.UNKNOWN_PHOTO,
        previewUrl = backdropDto.previewUrl ?: Backdrop.UNKNOWN_PREVIEW_URL
    )


    fun mapListActorsDtoActors(listActorsDto: List<ActorDto>) = listActorsDto.map {
        mapActorDtoActor(it)
    }

    fun mapActorDtoActor(actorDto: ActorDto) = Actor(
        id = actorDto.id,
        photoUrl = actorDto.photoUrl ?: Actor.UNKNOWN_PHOTO,
        name = actorDto.name ?: Actor.UNKNOWN_NAME,
        listMovies = mapListMovieActorMovieActor(actorDto.listMovieDto),
        dateOfBirth = actorDto.birthday ?: Actor.UNKNOWN_BIRTH,
        listProfession = mapListProfessionDtoToListProfession(actorDto.listProfessionDto)
    )

    fun mapListMovieActorMovieActor(list: List<MovieActorDto>) = list.map {
        mapMovieActorDtoMovieActor(it)
    }

    fun mapMovieActorDtoMovieActor(movieActorDto: MovieActorDto) = MovieActor(
        id = movieActorDto.id
    )

    fun mapProfessionDtoProfession(professionDto: ProfessionDto) = Profession(
        value = professionDto.value ?: Profession.UNKNOWN_VALUE
    )

    fun mapListProfessionDtoToListProfession(list: List<ProfessionDto>) = list.map {
        mapProfessionDtoProfession(it)
    }

    fun mapListCountriesDtoCountries(listCountriesDto: List<CountriesDto>) = listCountriesDto.map {
        mapCountriesDtoCountries(it)
    }

    fun mapCountriesDtoCountries(countriesDto: CountriesDto) = Countries(
        name = countriesDto.name ?: Countries.UNKNOWN_NAME
    )

    fun mapPosterDtoPoster(posterDto: PosterDto) = Poster(
        url = posterDto.url ?: Poster.UNKNOWN_URL
    )

    fun mapRaitingDtoRaiting(ratingDto: RatinggDto?) = Rating(
        rating = ratingDto?.ratingKinoPoisk ?: Rating.UNKNOWN_RATING
    )

    fun mapListMovieDtoMovie(listMovieDto: List<MovieDto>) = listMovieDto.map {
        mapMovieDtoMovie(it)
    }

    fun mapListSimilarMovieDtoSimilarMovie(listSimilarMovieDto: List<SimilarMovieDto>) : List<SimilarMovie> {
        return if (listSimilarMovieDto.isNotEmpty()){
            listSimilarMovieDto.map {
                mapSimilarMovieDtoSimilarMovie(it)
            }
        } else
            emptyList()
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