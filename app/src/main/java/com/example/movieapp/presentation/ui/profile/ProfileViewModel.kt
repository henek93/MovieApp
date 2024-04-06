package com.example.movieapp.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.RepositoryImpl
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.useCases.GetListMovieUseCase
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val repository = RepositoryImpl()
    private val getListMovieUseCase = GetListMovieUseCase(repository)

    private val _listMovie = MutableLiveData<List<Movie>>()
    val listMovie: LiveData<List<Movie>>
        get() = _listMovie

    private val _text = MutableLiveData<String>().apply {
        value = "This is main Fragment"
    }
    val text: LiveData<String> = _text


    fun getListMovie(){
        viewModelScope.launch {
            _listMovie.value = getListMovieUseCase.getListMovie(1, listMovie.value)
        }
    }
}