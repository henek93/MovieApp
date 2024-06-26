package com.example.movieapp.presentation.ui.movie

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
import com.example.movieapp.databinding.FragmentMovieBinding
import com.example.movieapp.domain.enteties.Movie
import com.example.movieapp.presentation.MovieViewModelFactory
import com.example.movieapp.presentation.adapters.ActorAdapter
import com.example.movieapp.presentation.adapters.MoviePosterAdapter
import com.example.movieapp.presentation.ui.actor.ActorFragment
import com.squareup.picasso.Picasso
import javax.inject.Inject


class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]
    }

    private val actorAdapter by lazy {
        ActorAdapter()
    }

    private val similarMoviesAdapter by lazy {
        MoviePosterAdapter()
    }

    private var movieId: Int? = null

    private val component by lazy {
        (requireActivity().application as MovieApplication).component
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)

        parseArgs()
    }

    private fun parseArgs() {
        movieId = requireArguments().getInt(MOVIE_ID_KEY)

        //Нужно обработать ошибки)
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

    private fun setOnLikeClickListener(movie: Movie) {
        binding.imageLike.setOnClickListener {
            if (movie.isFavourite){
                viewModel.deleteLike(movie.id)
                binding.imageLike.setImageResource(R.drawable.ic_favorite)
            }
            else {
                viewModel.makeLike(movie)
                binding.imageLike.setImageResource(R.drawable.ic_favorite_true)
            }
        }
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
        movieId?.let { viewModel.getCurrentMovie(it) }

    }

    private fun setOnActorClickListener(){
        actorAdapter.onActorClickListener = {

            val args = bundleOf(
                ActorFragment.ACTOR_ID_KEY to it
            )
            findNavController().navigate(
                R.id.action_movieFragment_to_actorFragment, args
            )
        }
    }

    private fun setOnMoviePosterClickListener(){
        similarMoviesAdapter.onPosterClickListener = {
            val args = bundleOf(
                MOVIE_ID_KEY to it
            )
            findNavController().navigate(
                R.id.action_movieFragment_self, args
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

                if (it.isFavourite){
                    imageLike.setImageResource(R.drawable.ic_favorite_true)
                }else
                    imageLike.setImageResource(R.drawable.ic_favorite)

                setOnLikeClickListener(it)
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

    companion object{

        const val MOVIE_ID_KEY = "movie id key"
    }
}