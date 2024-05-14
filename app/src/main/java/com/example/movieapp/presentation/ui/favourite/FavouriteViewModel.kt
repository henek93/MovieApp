package com.example.movieapp.presentation.ui.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.useCases.databaseUseCases.DeleteMovieFromDbUseCase
import com.example.movieapp.domain.useCases.databaseUseCases.GetListFavouriteMovieUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouriteViewModel @Inject constructor(
    private val getListFavouriteMovieUseCase: GetListFavouriteMovieUseCase,
    private val deleteMovieFromDbUseCase: DeleteMovieFromDbUseCase
) : ViewModel() {

    val favouriteMovies = getListFavouriteMovieUseCase.getListFavouriteMovie()

    fun deleteMovieFromDb(movieId: Int) {
        viewModelScope.launch {
            deleteMovieFromDbUseCase.deleteMovieFromDb(movieId)
        }
    }
}