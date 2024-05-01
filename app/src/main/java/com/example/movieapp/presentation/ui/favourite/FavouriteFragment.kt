package com.example.movieapp.presentation.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.FragmentFavouriteBinding
import com.example.movieapp.presentation.adapters.MovieFavouritePosterAdapter


class FavouriteFragment : Fragment() {

    private var _binding: FragmentFavouriteBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")

    private val movieAdapter by lazy {
        MovieFavouritePosterAdapter()
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[FavouriteViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)

        setUpRecyclerView()
        observeViewModel()
        setOnPosterClickListener()

        return binding.root
    }

    private fun setOnPosterClickListener() {
        movieAdapter.onMoviePosterClickListener = {
            TODO("navigate to movie fragment")
        }
    }

    private fun observeViewModel() {
        viewModel.favouriteMovies.observe(viewLifecycleOwner){
            movieAdapter.submitList(it)
        }
    }

    private fun setUpRecyclerView() {
        with(binding.favouriteRw){
            adapter = movieAdapter
        }
    }
}