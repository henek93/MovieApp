package com.example.movieapp.data.mapper

import com.example.movieapp.data.database.MovieDbModel
import com.example.movieapp.domain.enteties.Movie

class DbMapper {

    fun mapDbMovieToMovie(movieDbModel: MovieDbModel) = Movie(
        id = movieDbModel.id,
        name = movieDbModel.name,
        description = movieDbModel.description,
        poster = movieDbModel.poster,
        isFavourite = false,
        rating = movieDbModel.rating,
        pgRating = movieDbModel.pgRating,
        type = movieDbModel.type,
        genres = movieDbModel.genres,
        countries = movieDbModel.countries,
        actors = movieDbModel.actors,
        similarMovies = movieDbModel.similarMovies,
        backdrop = movieDbModel.backdrop,
        logo = movieDbModel.logo
    )

    fun mapMovieToDbMovie(movie: Movie) = MovieDbModel(
        id = movie.id,
        name = movie.name,
        description = movie.description,
        poster = movie.poster,
        isFavourite = false,
        rating = movie.rating,
        pgRating = movie.pgRating,
        type = movie.type,
        genres = movie.genres,
        countries = movie.countries,
        actors = movie.actors,
        similarMovies = movie.similarMovies,
        backdrop = movie.backdrop,
        logo = movie.logo
    )

    fun mapListDbMovieToListMovie(list: List<MovieDbModel>) = list.map {
        mapDbMovieToMovie(it)
    }
}