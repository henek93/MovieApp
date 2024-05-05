package com.example.movieapp.presentation.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.movieapp.MovieApplication
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMainBinding
import com.example.movieapp.presentation.MovieViewModelFactory
import com.example.movieapp.presentation.adapters.MoviePosterAdapter
import com.example.movieapp.presentation.adapters.MovieViewPagerAdapter
import com.example.movieapp.presentation.ui.movie.MovieFragment
import javax.inject.Inject
import kotlin.math.abs

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, movieViewModelFactory)[MainViewModel::class.java]
    }

    private lateinit var adapterPager: MovieViewPagerAdapter
    private lateinit var adapterRw1: MoviePosterAdapter
    private lateinit var adapterRw2: MoviePosterAdapter
    private lateinit var adapterRw3: MoviePosterAdapter


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
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        setupRecyclerView()
        loadData()
        observeViewModel()
        setPagerTransformer()
        setOnPosterClickListener()
        setLIkeClickListener()

        return binding.root
    }

    private fun setOnPosterClickListener() {
        adapterRw1.onPosterClickListener = {
            openMovieDescription(it)
        }

        adapterRw2.onPosterClickListener = {
            openMovieDescription(it)
        }

        adapterRw3.onPosterClickListener = {
            openMovieDescription(it)
        }
    }

    private fun setLIkeClickListener(){
        adapterRw1.onLikeClickListener = {
            if (it.isFavourite){
                viewModel.deleteLike(it.id)
            }
            else
                viewModel.makeLike(it)
        }
        adapterRw2.onLikeClickListener = {
            if (it.isFavourite){
                viewModel.deleteLike(it.id)
            }
            else
                viewModel.makeLike(it)
        }
        adapterRw3.onLikeClickListener = {
            if (it.isFavourite){
                viewModel.deleteLike(it.id)
            }
            else
                viewModel.makeLike(it)
        }
    }


    private fun openMovieDescription(currentMovieId: Int) {
        val args = bundleOf(
            MovieFragment.MOVIE_ID_KEY to currentMovieId
        )
        findNavController().navigate(
            R.id.action_mainFragment_to_nav_movie_and_actor, args
        )
    }

    private fun loadData() {
        viewModel.getMovieListPager(1, 5)
        viewModel.getMovieListRw1("драма", 1, 10)
        viewModel.getMovieListRw2("комедия", 1, 10)
        viewModel.getMovieListRw3("top250", 1, 10)
    }

    private fun setupRecyclerView() {
        with(binding.viewPager) {
            adapterPager = MovieViewPagerAdapter()
            adapter = adapterPager
        }

        with(binding.recyclerView1) {
            adapterRw1 = MoviePosterAdapter()
            adapter = adapterRw1
        }

        with(binding.recyclerView2) {
            adapterRw2 = MoviePosterAdapter()
            adapter = adapterRw2
        }

        with(binding.recyclerView3) {
            adapterRw3 = MoviePosterAdapter()
            adapter = adapterRw3
        }

        with(binding){
            recyclerView1.setHasFixedSize(true)
            recyclerView2.setHasFixedSize(true)
            recyclerView3.setHasFixedSize(true)
        }
    }

    private fun observeViewModel() {
        viewModel.pagerMovieList.observe(viewLifecycleOwner) {
            adapterPager.submitList(it)
        }

        viewModel.rwMovieList1.observe(viewLifecycleOwner) {
            adapterRw1.submitList(it)
        }

        viewModel.rwMovieList2.observe(viewLifecycleOwner) {
            adapterRw2.submitList(it)
        }

        viewModel.rwMovieList3.observe(viewLifecycleOwner) {
            adapterRw3.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setPagerTransformer() {
        binding.viewPager.offscreenPageLimit = 1

        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.15f * abs(position))
            // If you want a fading effect uncomment the next line:
            // page.alpha = 0.25f + (1 - abs(position))
        }

        binding.viewPager.setPageTransformer(pageTransformer)

        val itemDecoration = HorizontalMarginItemDecoration(
            requireContext(),
            R.dimen.viewpager_current_item_horizontal_margin
        )
        binding.viewPager.addItemDecoration(itemDecoration)

    }


    companion object {
        fun newInstanceMainFragment() = MainFragment()
    }
}