package com.example.movieapp.domain.enteties

data class Actor(
    val id: Int,
    val photoUrl: String,
    val name: String,
    val description: String
){

    companion object{

        const val UNKNOWN_NAME = "Неизвестное имя актера"
        const val UNKNOWN_PHOTO = "https://www.riakchr.ru/upload/iblock/39d/uavmacl6tbi2jttr09ah6csd1zlt1bbg.jpg"
        const val UNKNOWN_DESCRIPTION = "Нет описания"
    }
}