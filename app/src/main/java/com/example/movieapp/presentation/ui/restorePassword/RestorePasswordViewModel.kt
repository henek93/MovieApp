package com.example.movieapp.presentation.ui.restorePassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class RestorePasswordViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean>
        get() = _isSuccess

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun restorePassword(email: String){
        auth.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                _isSuccess.value = true
            }
            .addOnFailureListener {
                _error.value = it.message.toString()
            }
    }
}