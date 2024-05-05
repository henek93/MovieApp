package com.example.movieapp

import android.app.Application
import com.example.movieapp.di.DaggerApplicationComponent

class MovieApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}