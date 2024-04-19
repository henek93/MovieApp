package com.example.movieapp.presentation.ui.actor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.FragmentActorBinding
import com.example.movieapp.domain.enteties.Actor
import com.example.movieapp.presentation.adapters.MoviePosterAdapter


class ActorFragment : Fragment() {

    private val args by navArgs<ActorFragmentArgs>()

    private var _binding: FragmentActorBinding? = null

    private val binding: FragmentActorBinding
        get() = _binding ?: throw RuntimeException("Binding == null")


    private val viewModel by lazy {
        ViewModelProvider(this)[ActorViewModel::class.java]
    }

    private lateinit var adapterMovie: MoviePosterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActorBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        observeViewModel()
        setRecyclerViews()
    }

    private fun loadData(){
        viewModel.getActor(args.actorId)
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}