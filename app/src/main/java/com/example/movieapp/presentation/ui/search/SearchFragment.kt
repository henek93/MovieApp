package com.example.movieapp.presentation.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.MovieApplication
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSearchBinding
import com.example.movieapp.presentation.MovieViewModelFactory
import com.example.movieapp.presentation.adapters.GridSpacingItemDecoration
import com.example.movieapp.presentation.adapters.MoviePosterAdapter
import com.example.movieapp.presentation.ui.movie.MovieFragment
import javax.inject.Inject


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, movieViewModelFactory)[SearchViewModel::class.java]
    }
    private val adapterMoviePoster by lazy {
        MoviePosterAdapter()
    }

    private val component by lazy {
        (requireActivity().application as MovieApplication).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        setRecyclerView()
        viewModel.loadData()
        addQueryChangeListener()
        setOnPosterClickListener()
    }

    private fun setOnPosterClickListener() {
        adapterMoviePoster.onPosterClickListener = {
            val args = bundleOf(
                MovieFragment.MOVIE_ID_KEY to it
            )
            findNavController().navigate(
                R.id.action_navigation_fragment_search_to_nav_movie_and_actor, args
            )
        }
    }

    private fun observeViewModel() {
        viewModel.listMovie.observe(viewLifecycleOwner){
            adapterMoviePoster.submitList(it)
        }

        viewModel.textDescription.observe(viewLifecycleOwner){
            binding.textView.text = it
        }
    }

    private fun setRecyclerView() {
        binding.searchRecyclerView.adapter = adapterMoviePoster
        binding.searchRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        val spanCount = 3 // 3 columns

        val spacing = 25 // 50px

        val includeEdge = false
        binding.searchRecyclerView.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing, includeEdge))
    }

    private fun addQueryChangeListener() {
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.sendQuery(newText)
                return true
            }

        })
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}