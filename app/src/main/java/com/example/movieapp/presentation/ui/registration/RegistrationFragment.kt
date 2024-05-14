package com.example.movieapp.presentation.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")

    private val viewModel by lazy {
        ViewModelProvider(this)[RegistrationViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        setOnclickListener()
    }

    private fun setOnclickListener() {
        with(binding){
            buttonSignIn.setOnClickListener {
                val email = inputEmail.text.toString()
                val password = inputPassword.text.toString()
                val name = inputName.text.toString()
                val lastName = inputLastName.text.toString()
                viewModel.registrate(email, password, name, lastName)
            }
        }
    }

    private fun observeViewModel() {
        viewModel.user.observe(viewLifecycleOwner){
            if (it != null){
                findNavController().navigate(
                    RegistrationFragmentDirections.actionRegistrationFragmentToSignInFragment()
                )
            }
        }

        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}