package com.example.movieapp.domain.enteties

import java.util.Date

data class Actor(
    val id: Int,
    val photoUrl: String,
    val name: String,
    val listProfession: List<Profession>,
    val dateOfBirth: String,
    val listMovies: List<MovieActor>
){

    companion object{

        const val UNKNOWN_NAME = "Неизвестное имя актера"
        const val UNKNOWN_PHOTO = "https://www.riakchr.ru/upload/iblock/39d/uavmacl6tbi2jttr09ah6csd1zlt1bbg.jpg"
        const val UNKNOWN_BIRTH = "Дата рождения неизвестна"
    }
}