package com.example.movieapp.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.FragmentMainBinding
import com.example.movieapp.presentation.adapters.MoviePosterAdapter
import java.lang.RuntimeException

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private lateinit var movieAdapterTop: MoviePosterAdapter
    private lateinit var movieAdapterAdv: MoviePosterAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        viewModel.getListMovie()
        observeViewModel()

        return root
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
        viewModel.listMovie.observe(viewLifecycleOwner){
            movieAdapterTop.submitList(it)
            movieAdapterAdv.submitList(it)
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