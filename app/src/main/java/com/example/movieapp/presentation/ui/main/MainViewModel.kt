package com.example.movieapp.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.enteties.MoviePoster
import com.example.movieapp.domain.useCases.databaseUseCases.AddMovieToDbUseCase
import com.example.movieapp.domain.useCases.databaseUseCases.DeleteMovieFromDbUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetListMoviesWithGenreUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetListNewMoviesUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetMovieUseCase
import com.example.movieapp.domain.useCases.networkUseCases.GetTopListMoviesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
        private val getTopListMoviesUseCase: GetTopListMoviesUseCase,
        private val getNewListMoviesUseCase: GetListNewMoviesUseCase,
        private val getListMoviesWithGenreUseCase: GetListMoviesWithGenreUseCase,
        private val getMovieUseCase: GetMovieUseCase,
        private val addMovieToDbUseCase: AddMovieToDbUseCase,
        private val deleteMovieFromDbUseCase: DeleteMovieFromDbUseCase
) : ViewModel() {

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

    fun makeLike(moviePoster: MoviePoster){
        viewModelScope.launch {
            val movie = getMovieUseCase.getMovie(moviePoster.id)
            addMovieToDbUseCase.addMovieToDb(
                movie
            )
        }
    }

    fun deleteLike(movieId: Int){
        viewModelScope.launch{
            deleteMovieFromDbUseCase.deleteMovieFromDb(movieId)
        }
    }
}