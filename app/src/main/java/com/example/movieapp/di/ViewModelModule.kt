package com.example.movieapp.di

import androidx.lifecycle.ViewModel
import com.example.movieapp.presentation.ui.actor.ActorViewModel
import com.example.movieapp.presentation.ui.favourite.FavouriteViewModel
import com.example.movieapp.presentation.ui.main.MainViewModel
import com.example.movieapp.presentation.ui.movie.MovieViewModel
import com.example.movieapp.presentation.ui.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(ActorViewModel::class)
    fun bindActorViewModel(actorViewModel: ActorViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(FavouriteViewModel::class)
    fun bindFavouriteViewModel(favouriteViewModel: FavouriteViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(MovieViewModel::class)
    fun bindMovieViewModel(movieViewModel: MovieViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SearchViewModel::class)
    fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel
}