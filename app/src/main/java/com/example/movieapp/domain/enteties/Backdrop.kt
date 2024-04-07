package com.example.movieapp.domain.enteties

data class Backdrop(
    val url: String = "https://wcinema.ru/upload/000/u18/4/d/079ae886.jpg",
    val previewUrl: String = "https://wcinema.ru/upload/000/u18/4/d/079ae886.jpg"
){

    companion object{

        const val UNKNOWN_PHOTO = "https://www.riakchr.ru/upload/iblock/39d/uavmacl6tbi2jttr09ah6csd1zlt1bbg.jpg"
        const val UNKNOWN_PREVIEW_URL = "https://wcinema.ru/upload/000/u18/4/d/079ae886.jpg"
    }
}