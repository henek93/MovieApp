package com.example.movieapp.presentation.ui.restorePassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentRestorePasswordBinding

class RestorePasswordFragment : Fragment() {

    private var _binding: FragmentRestorePasswordBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding == null")



    private val viewModel by lazy {
        ViewModelProvider(this)[RestorePasswordViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestorePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClickListeners()
        viewModelObserver()
    }

    private fun viewModelObserver() {
        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewModel.isSuccess.observe(viewLifecycleOwner){
            if (it){
                findNavController().navigate(
                    RestorePasswordFragmentDirections.actionRestorePasswordFragmentToSignInFragment()
                )
            }
        }
    }

    private fun setOnClickListeners() {
        with(binding){
            buttonRestore.setOnClickListener {
                val email = inputEmail.text?.trim().toString()
                viewModel.restorePassword(email)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}