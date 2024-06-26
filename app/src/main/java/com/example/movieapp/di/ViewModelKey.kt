package com.example.movieapp.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@ApplicationScope
@MapKey
annotation class ViewModelKey(val viewModel: KClass<out ViewModel>)
