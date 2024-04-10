package com.example.movieapp.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.FragmentMainBinding
import com.example.movieapp.domain.enteties.Genre
import com.example.movieapp.presentation.adapters.MoviePosterAdapter
import java.lang.RuntimeException

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private lateinit var adapterPaeger: MoviePosterAdapter
    private lateinit var adapterRw1: MoviePosterAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        loadData()
        observeViewModel()

        return root
    }

    private fun loadData(){
        viewModel.getMovieListPager(1,5)
        viewModel.getMovieListRw1(Genre.ADVENTURE_GENRE, 1, 10)
        viewModel.getMovieListRw2(Genre.CRIMINAL_GENRE, 1, 10)
        viewModel.getMovieListRw3("top250", 1, 10)
    }

    private fun setupRecyclerView() {
        with(binding.rwTopNewFilms){
            movieAdapterTop = MoviePosterAdapter()
            adapter = movieAdapterTop
        }

        with(binding.rwAdventureBest){
            movieAdapterAdv = MoviePosterAdapter()
            adapter = movieAdapterAdv
        }
    }

    private fun observeViewModel(){
        viewModel.getTopMovieList.observe(viewLifecycleOwner){
            adapterPaeger.submitList(it)
            adapterRw1.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun newInstanceMainFragment() = MainFragment()
    }
}