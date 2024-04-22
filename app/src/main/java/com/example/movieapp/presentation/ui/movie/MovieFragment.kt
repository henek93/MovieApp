package com.example.movieapp.presentation.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movieapp.databinding.FragmentMovieBinding
import com.example.movieapp.presentation.adapters.ActorAdapter
import com.example.movieapp.presentation.adapters.MoviePosterAdapter
import com.squareup.picasso.Picasso


class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")

    private val viewModel by lazy {
        ViewModelProvider(this)[MovieViewModel::class.java]
    }

    private val actorAdapter by lazy {
        ActorAdapter()
    }

    private val similarMoviesAdapter by lazy {
        MoviePosterAdapter()
    }

    private val args by navArgs<MovieFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getCurrentFilm()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        setRecyclerViews()
        setOnItemClickListeners()
    }

    private fun setOnItemClickListeners() {
        setOnActorClickListener()
        setOnMoviePosterClickListener()
    }

    private fun setRecyclerViews() {
        with(binding.rwActors){
            adapter = actorAdapter
        }

        with(binding.rwSimilarMovies){
            adapter = similarMoviesAdapter
        }
    }

    private fun getCurrentFilm() {
        viewModel.getCurrentMovie(args.movieid)

    }

    private fun setOnActorClickListener(){
        actorAdapter.onActorClickListener = {
            findNavController().navigate(
                MovieFragmentDirections.actionNavigationFragmentMovieToNavigationFragmentActor(it)
            )
        }
    }

    private fun setOnMoviePosterClickListener(){
        similarMoviesAdapter.onPosterClickListener = {
            findNavController().navigate(
                MovieFragmentDirections.actionNavigationFragmentMovieSelf(it)
            )
        }
    }


    private fun observeViewModel() {
        viewModel.currentMovie.observe(viewLifecycleOwner){
            with(binding){
                Picasso.get()
                    .load(it.poster.url)
                    .into(moviePosterImage)

                movieAgeRestrictionsText.text = "${it.pgRating}+"
                movieNameText.text = it.name
                movieGenresText.text = it.genres.joinToString(",") { it.name }
                ratingBar.rating = (it.rating.rating.toFloat() / 5)
                movieStorylineText.text = it.description

                actorAdapter.submitList(it.actors)

                viewModel.getListSimilarMovie()
            }
        }

        viewModel.listSimilarMovie.observe(viewLifecycleOwner){
            similarMoviesAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}