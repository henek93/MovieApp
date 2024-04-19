package com.example.movieapp.presentation.ui.actor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.repositoryImpl.NetworkRepositoryImpl
import com.example.movieapp.domain.enteties.Actor
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.MovieActor
import com.example.movieapp.domain.enteties.MoviePoster
import com.example.movieapp.domain.useCases.networkUseCases.GetActorUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetMoviePosterUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetMovieUseCase
import kotlinx.coroutines.launch

class ActorViewModel() : ViewModel() {

    private val repository = NetworkRepositoryImpl()
    private val getActorUseCase = GetActorUseCase(repository)
    private val getMoviePosterUseCase = GetMoviePosterUseCase(repository)

    private val _actorLiveData = MutableLiveData<Actor>()
    val actorLiveData: LiveData<Actor>
        get() = _actorLiveData

    private val _listMovieActor = MutableLiveData<List<MoviePoster>>()
    val listMovieActor: LiveData<List<MoviePoster>>
        get() = _listMovieActor

    fun getActor(actorId: Int) {
        viewModelScope.launch {
            _actorLiveData.value = getActorUseCase.getActor(actorId)
        }
    }

    fun getListMove() {
        val listMovie = mutableListOf<MoviePoster>()
        actorLiveData.value?.let {
            for (i in it.listMovies) {
                viewModelScope.launch {
                    listMovie.add(getMoviePosterUseCase.getMoviePoster(i.id))
                }
            }
            _listMovieActor.value = listMovie.sortedBy { it.rating.rating }.reversed()
        }

    }
}