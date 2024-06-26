package com.example.movieapp.presentation.ui.actor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.enteties.Actor
import com.example.movieapp.domain.enteties.MoviePoster
import com.example.movieapp.domain.useCases.networkUseCases.GetActorUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetMoviePosterUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ActorViewModel @Inject constructor(
    private val getActorUseCase: GetActorUseCase,
    private val getMoviePosterUseCase: GetMoviePosterUseCase
) : ViewModel() {


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
            if (it.listMovies.size < 5) {
                for (i in it.listMovies) {
                    viewModelScope.launch {
                        listMovie.add(getMoviePosterUseCase.getMoviePoster(i.id))
                        _listMovieActor.value = listMovie
                    }
                }
            }
            else {
                for (i in 0 until 5) {
                    viewModelScope.launch {
                        listMovie.add(getMoviePosterUseCase.getMoviePoster(it.listMovies[i].id))
                        _listMovieActor.value = listMovie
                    }
                }
            }
        }
    }
}