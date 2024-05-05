package com.example.movieapp.presentation.ui.actor

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.movieapp.MovieApplication
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentActorBinding
import com.example.movieapp.domain.enteties.Actor
import com.example.movieapp.presentation.MovieViewModelFactory
import com.example.movieapp.presentation.adapters.MoviePosterAdapter
import com.example.movieapp.presentation.ui.movie.MovieFragment
import javax.inject.Inject


class ActorFragment : Fragment() {

    private var _binding: FragmentActorBinding? = null
    private val binding: FragmentActorBinding
        get() = _binding ?: throw RuntimeException("Binding == null")

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, movieViewModelFactory)[ActorViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as MovieApplication).component
    }

    private lateinit var adapterMovie: MoviePosterAdapter

    private var actorId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActorBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)

        parseArgs()
    }

    private fun parseArgs() {
        actorId = requireArguments().getInt(ACTOR_ID_KEY)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        observeViewModel()
        setRecyclerViews()
    }

    private fun loadData(){
        actorId?.let { viewModel.getActor(it) }
    }


    private fun observeViewModel(){
        viewModel.actorLiveData.observe(viewLifecycleOwner){
            with(binding){
                Glide.with(requireContext())
                    .asBitmap()
                    .load(it.photoUrl)
                    .fitCenter()
                    .into(actorPhoto)

                actorNameText.text = it.name
                textBearthday.text = Actor.convertData(it.dateOfBirth)
                actorJobsText.text = it.listProfession.joinToString(", ") { it.value }

                viewModel.getListMove()
            }
        }

        viewModel.listMovieActor.observe(viewLifecycleOwner) {
            adapterMovie.submitList(it)
        }
    }

    private fun setRecyclerViews(){
        with(binding.recyclerViewActor){
            adapterMovie = MoviePosterAdapter()
            adapter = adapterMovie
        }
        setOnMovieClickListener()
    }

    private fun setOnMovieClickListener(){
        adapterMovie.onPosterClickListener = {
            val args = bundleOf(
                MovieFragment.MOVIE_ID_KEY to it
            )
            findNavController().navigate(
                R.id.action_actorFragment_to_movieFragment, args
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{

        const val ACTOR_ID_KEY = "actor id key"
    }
}