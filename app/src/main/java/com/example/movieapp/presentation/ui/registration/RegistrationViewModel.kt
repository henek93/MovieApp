package com.example.movieapp.presentation.ui.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.domain.enteties.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class RegistrationViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val referenceUsers = firebaseDatabase.getReference("Users")



    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _user = MutableLiveData<FirebaseUser>()
    val user: LiveData<FirebaseUser>
        get() = _user

    init {
        auth.addAuthStateListener {
            if (it.currentUser != null){
                _user.value = it.currentUser
            }
        }

    }

    fun registrate(
        email: String,
        password: String,
        name: String,
        lastName: String,
    ){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                val user1 = it.user
                if (user1 != null){
                    val newUser = User(
                        id = user1.uid,
                        name = name,
                        lastName = lastName,
                        email = email,
                        listFavouriteMovies = null
                    )

                    referenceUsers.child(user1.uid).setValue(newUser)
                }
            }
            .addOnFailureListener {
                _error.value = it.message.toString()
            }

    }
}