package com.example.movieapp.presentation.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.databinding.FragmentProfileBinding

import com.example.movieapp.presentation.ui.main.MainFragment

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

//    private val  notificationsViewModel by lazy {
//        ViewModelProvider(this)[ProfileViewModel::class.java]
//    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textNotifications
//
//        notificationsViewModel.getListMovie()
//
//        notificationsViewModel.listMovie.observe(viewLifecycleOwner){
//            textView.text = it.get(0).name
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{

        fun newInstanceProfileFragment(): Fragment = ProfileFragment()
    }
}