package com.example.movieapp.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.enteties.MoviePoster
import com.example.movieapp.domain.useCases.networkUseCases.GetListMoviePostersByNameUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetTopListMoviesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getListMoviePostersByNameUseCase: GetListMoviePostersByNameUseCase,
    private val getListTopListMoviesUseCase: GetTopListMoviesUseCase
) : ViewModel() {

    private val _textDescription = MutableLiveData<String>()
    val textDescription: LiveData<String>
        get() = _textDescription

    private val _listMovie = MutableLiveData<List<MoviePoster>>()
    val listMovie: LiveData<List<MoviePoster>>
        get() = _listMovie

    fun loadData() {
        viewModelScope.launch {
            _listMovie.value = getListTopListMoviesUseCase.getTopListMovies(
                limit = 30,
                list = "top250",
                page = 1
            )
        }
    }

    fun sendQuery(newText: String?) {
        if (newText == null) {
            viewModelScope.launch {
                _listMovie.value = getListTopListMoviesUseCase.getTopListMovies(
                    list = "top250",
                    limit = 30,
                    page = 1
                )
            }
            _textDescription.value = "Возможно вас это заинтересует:"
        } else {
            viewModelScope.launch {
                _listMovie.value =
                    getListMoviePostersByNameUseCase.getListMoviePosterByName(newText)
            }
            _textDescription.value = "Результаты по вашему запросу"
        }
    }
}