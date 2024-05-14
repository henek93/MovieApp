package com.example.movieapp.presentation.ui.signIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentSignInBinding

class SignInFragment: Fragment() {

    private var _binding: FragmentSignInBinding? = null

    private val viewModel by lazy {
        ViewModelProvider(this)[SignInViewModel::class.java]
    }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickListeners()
        setViewModelObserver()
    }

    private fun setViewModelObserver() {
        viewModel.user.observe(viewLifecycleOwner){
            if (it != null){
                findNavController().navigate(
                    SignInFragmentDirections.actionSignInFragmentToProfileFragment(it.uid)
                )
            }
        }

        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setClickListeners() {
        with(binding){
            buttonSignIn.setOnClickListener {
                val login = inputEmail.text.toString()
                val password = inputPassword.text.toString()
                viewModel.signIn(login, password)
            }

            twForgotPasssword.setOnClickListener {
                findNavController().navigate(
                    SignInFragmentDirections.actionSignInFragmentToRestorePasswordFragment()
                )
            }

            twRegistration.setOnClickListener {
                findNavController().navigate(
                    SignInFragmentDirections.actionSignInFragmentToRegistrationFragment()
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}