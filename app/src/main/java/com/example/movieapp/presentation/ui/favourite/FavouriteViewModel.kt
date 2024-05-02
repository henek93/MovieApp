package com.example.movieapp.presentation.ui.favourite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.repositoryImpl.DatabaseRepositoryImpl
import com.example.movieapp.domain.useCases.databaseUseCases.DeleteMovieFromDbUseCase
import com.example.movieapp.domain.useCases.databaseUseCases.GetListFavouriteMovieUseCase
import com.example.movieapp.domain.useCases.databaseUseCases.GetMovieFromDbUseCase
import kotlinx.coroutines.launch

class FavouriteViewModel(application: Application): AndroidViewModel(application) {

    private val repository = DatabaseRepositoryImpl(application)
    private val getListFavouriteMovieUseCase = GetListFavouriteMovieUseCase(repository)
    private val getMovieFromDbUseCase = GetMovieFromDbUseCase(repository)
    private val deleteMovieFromDbUseCase = DeleteMovieFromDbUseCase(repository)

    val favouriteMovies = getListFavouriteMovieUseCase.getListFavouriteMovie()

    fun deleteMovieFromDb(movieId: Int){
        viewModelScope.launch {
            deleteMovieFromDbUseCase.deleteMovieFromDb(movieId)
        }
    }
}