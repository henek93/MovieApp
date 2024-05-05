package com.example.movieapp.presentation.ui.favourite

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieapp.MovieApplication
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentFavouriteBinding
import com.example.movieapp.presentation.MovieViewModelFactory
import com.example.movieapp.presentation.adapters.MovieFavouritePosterAdapter
import com.example.movieapp.presentation.ui.movie.MovieFragment
import javax.inject.Inject


class FavouriteFragment : Fragment() {

    private var _binding: FragmentFavouriteBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, movieViewModelFactory)[FavouriteViewModel::class.java]
    }

    private val movieAdapter by lazy {
        MovieFavouritePosterAdapter()
    }

    private val component by lazy {
        (requireActivity().application as MovieApplication).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
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
            openMovieDescription(it)
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

    private fun openMovieDescription(currentMovieId: Int) {
        val args = bundleOf(
            MovieFragment.MOVIE_ID_KEY to currentMovieId
        )
        findNavController().navigate(
            R.id.action_favouriteFragment_to_nav_movie_and_actor, args
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}