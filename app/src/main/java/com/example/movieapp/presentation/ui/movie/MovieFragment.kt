package com.example.movieapp.presentation.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.FragmentMovieBinding
import com.example.movieapp.domain.enteties.Movie


class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")

    private val viewModel by lazy {
        ViewModelProvider(this)[MovieViewModel::class.java]
    }

    private var movieId =Movie.NOT_ID


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
        parcParams()
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCurrentFilm()
        observeViewModel()
    }

    private fun getCurrentFilm() {
        viewModel.getCurrentMovie(movieId)
    }


    private fun parcParams() {
        if (!requireArguments().containsKey(MOVIE_ID))
            throw RuntimeException("Dont have movie id")
        movieId = requireArguments().getInt(MOVIE_ID)
    }

    private fun observeViewModel() {
        viewModel.currentMovie.observe(viewLifecycleOwner){
            TODO("need to add adapters for recyclerViewes")
        }
    }

    companion object {

        const val MOVIE_ID = "movie_id"

        @JvmStatic
        fun newInstance(movieId: Int) =
            MovieFragment().apply {
                arguments = Bundle().apply {
                    putInt(MOVIE_ID, movieId)
                }
            }
    }
}