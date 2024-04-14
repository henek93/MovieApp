package com.example.movieapp.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMainBinding
import com.example.movieapp.domain.enteties.Genre
import com.example.movieapp.presentation.adapters.MoviePosterAdapter
import com.example.movieapp.presentation.adapters.MovieViewPagerAdapter
import java.lang.RuntimeException
import kotlin.math.abs

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private lateinit var adapterPager: MovieViewPagerAdapter
    private lateinit var adapterRw1: MoviePosterAdapter
    private lateinit var adapterRw2: MoviePosterAdapter
    private lateinit var adapterRw3: MoviePosterAdapter


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
        setPagerTransformer()

        return root
    }

    private fun loadData(){
        viewModel.getMovieListPager(1,5)
        viewModel.getMovieListRw1("драма", 1, 10)
        viewModel.getMovieListRw2("комедия", 1, 10)
        viewModel.getMovieListRw3("top250", 1, 10)
    }

    private fun setupRecyclerView() {
        with(binding.viewPager){
            adapterPager = MovieViewPagerAdapter()
            adapter = adapterPager
        }

        with(binding.recyclerView1){
            adapterRw1 = MoviePosterAdapter()
            adapter = adapterRw1
        }

        with(binding.recyclerView2){
            adapterRw2 = MoviePosterAdapter()
            adapter = adapterRw2
        }

        with(binding.recyclerView3){
            adapterRw3 = MoviePosterAdapter()
            adapter = adapterRw3
        }
    }

    private fun observeViewModel(){
        viewModel.pagerMovieList.observe(viewLifecycleOwner){
            adapterPager.submitList(it)
        }

        viewModel.rwMovieList1.observe(viewLifecycleOwner){
            adapterRw1.submitList(it)
        }

        viewModel.rwMovieList2.observe(viewLifecycleOwner){
            adapterRw2.submitList(it)
        }

        viewModel.rwMovieList3.observe(viewLifecycleOwner){
            adapterRw3.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setPagerTransformer(){
        binding.viewPager.offscreenPageLimit = 1

        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
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


    companion object{
        fun newInstanceMainFragment() = MainFragment()
    }
}