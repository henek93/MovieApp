package com.example.movieapp.presentation.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.repositoryImpl.NetworkRepositoryImpl
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.useCases.networkUseCases.GetMovieUseCase
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val repository = NetworkRepositoryImpl()
    private val getMovieUseCase = GetMovieUseCase(repository)

    private val _currentMovie = MutableLiveData<Movie>()
    val currentMovie: LiveData<Movie>
        get() = _currentMovie

    fun getCurrentMovie(idMovie: Int) {
        viewModelScope.launch {
            _currentMovie.value = getMovieUseCase.getMovie(idMovie)
        }
    }
}