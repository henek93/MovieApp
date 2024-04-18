package com.example.movieapp.presentation.ui.actor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.repositoryImpl.NetworkRepositoryImpl
import com.example.movieapp.domain.enteties.Actor
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.MovieActor
import com.example.movieapp.domain.useCases.networkUseCases.GetActorUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetMovieUseCase
import kotlinx.coroutines.launch

class ActorViewModel() : ViewModel() {

    private val repository = NetworkRepositoryImpl()
    private val getActorUseCase = GetActorUseCase(repository)
    private val getMovieUseCase = GetMovieUseCase(repository)

    private val _actorLiveData = MutableLiveData<Actor>()
    val actorLiveData: LiveData<Actor>
        get() = _actorLiveData

    private val _listMovieActor = MutableLiveData<List<Movie>>()
    val listMovieActor: LiveData<List<Movie>>
        get() = _listMovieActor

    fun getActor(actorId: Int) {
        viewModelScope.launch {
            _actorLiveData.value = getActorUseCase.getActor(actorId)
        }
    }

    fun getListMove(listActorMovie: List<MovieActor>){
        val listMovie = mutableListOf<Movie>()

        for (i in listActorMovie){
            viewModelScope.launch {
                listMovie.add(getMovieUseCase.getMovie(i.id))
            }
        }
        _listMovieActor.value = listMovie.sortedBy { it.rating.rating }.reversed()
    }
}