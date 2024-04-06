package com.example.movieapp.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.getListMovie()

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root: View = binding.root

        mainViewModel.listMovie.observe(viewLifecycleOwner){
            binding.mainText.text = it[0].name
        }

        return root
    }


    private fun observeViewModel(){

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun newInstanceMainFragment(): MainFragment = MainFragment()
    }
}