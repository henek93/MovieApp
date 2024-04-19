package com.example.movieapp.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.repositoryImpl.NetworkRepositoryImpl
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.domain.enteties.MoviePoster
import com.example.movieapp.domain.useCases.networkUseCases.GetListMoviesWithGenreUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetListNewMoviesUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetTopListMoviesUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = NetworkRepositoryImpl()
    private val getTopListMoviesUseCase = GetTopListMoviesUseCase(repository)
    private val getNewListMoviesUseCase = GetListNewMoviesUseCase(repository)
    private val getListMoviesWithGenreUseCase = GetListMoviesWithGenreUseCase(repository)

    private val _pagerMovieList = MutableLiveData<List<MoviePoster>>()
    val pagerMovieList: LiveData<List<MoviePoster>>
        get() = _pagerMovieList

    private val _rwMovieList1 = MutableLiveData<List<MoviePoster>>()
    val rwMovieList1: LiveData<List<MoviePoster>>
        get() = _rwMovieList1

    private val _rwMovieList2 = MutableLiveData<List<MoviePoster>>()
    val rwMovieList2: LiveData<List<MoviePoster>>
        get() = _rwMovieList2

    private val _rwMovieList3 = MutableLiveData<List<MoviePoster>>()
    val rwMovieList3: LiveData<List<MoviePoster>>
        get() = _rwMovieList3


    fun getMovieListPager(page: Int, limit: Int){
        viewModelScope.launch{
            _pagerMovieList.value = getNewListMoviesUseCase.getTopNewMovies(
                page = page,
                limit = limit
            )
        }
    }


    fun getMovieListRw1(genre: String, page: Int, limit: Int){
        viewModelScope.launch {
            _rwMovieList1.value = getListMoviesWithGenreUseCase.getTopMoviesWithGenre(
                genre,
                page,
                limit
            )
        }
    }

    fun getMovieListRw2(genre: String, page: Int, limit: Int){
        viewModelScope.launch {
            _rwMovieList2.value = getListMoviesWithGenreUseCase.getTopMoviesWithGenre(
                genre,
                page,
                limit
            )
        }
    }

    fun getMovieListRw3(listName: String, page: Int, limit: Int){
        viewModelScope.launch {
            _rwMovieList3.value = getTopListMoviesUseCase.getTopListMovies(
                listName,
                page,
                limit
            )
        }
    }
}