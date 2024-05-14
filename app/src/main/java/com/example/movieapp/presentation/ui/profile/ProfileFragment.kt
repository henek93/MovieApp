package com.example.movieapp.presentation.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[ProfileViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usernameTextView.setOnClickListener {
            findNavController().navigate(
                ProfileFragmentDirections.actionProfileFragmentToSignInFragment()
            )
        }

        binding.twSignOut.setOnClickListener {
            viewModel.signOut()

        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.user.observe(viewLifecycleOwner){
            if (it != null){
               viewModel.getUserInfo()
                binding.twSignOut.isVisible = true
            }else{
                binding.twSignOut.isVisible = false
                binding.usernameTextView.text = "Войти в аккаунт"
                binding.twEmail.text = ""
            }
        }

        viewModel.userInfo.observe(viewLifecycleOwner){
            with(binding){
                usernameTextView.text = "${it.name} ${it.lastName}"
                twEmail.text = it.email
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{

        fun newInstanceProfileFragment(): Fragment = ProfileFragment()
    }
}