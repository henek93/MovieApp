package com.example.movieapp.presentation.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.repositoryImpl.NetworkRepositoryImpl
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.MoviePoster
import com.example.movieapp.domain.useCases.networkUseCases.GetMoviePosterUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetMovieUseCase
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val repository = NetworkRepositoryImpl()
    private val getMovieUseCase = GetMovieUseCase(repository)
    private val getMoviePosterUseCase = GetMoviePosterUseCase(repository)

    private val _currentMovie = MutableLiveData<Movie>()
    val currentMovie: LiveData<Movie>
        get() = _currentMovie

    private val _listSimilarMovie = MutableLiveData<List<MoviePoster>>()
    val listSimilarMovie: LiveData<List<MoviePoster>>
        get() = _listSimilarMovie

    fun getCurrentMovie(idMovie: Int) {
        viewModelScope.launch {
            _currentMovie.value = getMovieUseCase.getMovie(idMovie)
        }
    }

    fun getListSimilarMovie() {
        val listMovie = mutableListOf<MoviePoster>()
        _currentMovie.value?.let {
            if (it.similarMovies.size < 8) {
                for (i in it.similarMovies) {
                    viewModelScope.launch {
                        listMovie.add(getMoviePosterUseCase.getMoviePoster(it.id))
                        _listSimilarMovie.value = listMovie
                    }
                }
            } else {
                for (i in 0 until 8) {
                    viewModelScope.launch {
                        listMovie.add(getMoviePosterUseCase.getMoviePoster(it.similarMovies[i].id))
                        _listSimilarMovie.value = listMovie
                    }
                }
            }

        }
    }
}