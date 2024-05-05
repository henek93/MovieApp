package com.example.movieapp.di

import android.app.Application
import com.example.movieapp.MovieApplication
import com.example.movieapp.presentation.ui.actor.ActorFragment
import com.example.movieapp.presentation.ui.favourite.FavouriteFragment
import com.example.movieapp.presentation.ui.main.MainFragment
import com.example.movieapp.presentation.ui.movie.MovieFragment
import com.example.movieapp.presentation.ui.profile.ProfileFragment
import com.example.movieapp.presentation.ui.search.SearchFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(mainFragment: MainFragment)
    fun inject(movieFragment: MovieFragment)
    fun inject(searchFragment: SearchFragment)
    fun inject(favouriteFragment: FavouriteFragment)
    fun inject(profileFragment: ProfileFragment)
    fun inject(actorFragment: ActorFragment)
    fun inject(application: MovieApplication)

    @Component.Factory
    interface Factory{

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}