package com.example.movieapp.presentation.ui.signIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignInViewModel: ViewModel() {

    private var firebaseAuth: FirebaseAuth? = null

    private val _user = MutableLiveData<FirebaseUser?>(null)
    val user: LiveData<FirebaseUser?>
        get() = _user

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    init {
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth?.addAuthStateListener {
            _user.value = it.currentUser
        }
    }

    fun signIn(login: String, password: String){
        firebaseAuth?.signInWithEmailAndPassword(login, password)
            ?.addOnFailureListener {
                _error.value = it.message.toString()
            }
    }

    fun signOut(){
        firebaseAuth?.signOut()
    }
}