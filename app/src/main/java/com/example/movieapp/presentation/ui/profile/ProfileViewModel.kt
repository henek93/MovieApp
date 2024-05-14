package com.example.movieapp.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.domain.enteties.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileViewModel : ViewModel() {


    private var firebaseAuth: FirebaseAuth? = null
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val referenceUsers = firebaseDatabase.getReference("Users")

    private val _user = MutableLiveData<FirebaseUser?>(null)
    val user: LiveData<FirebaseUser?>
        get() = _user

    private val _userInfo = MutableLiveData<User>()
    val userInfo: LiveData<User>
        get() = _userInfo

    init {
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth?.addAuthStateListener {
            _user.value = it.currentUser
        }
    }


    fun getUserInfo(){
        referenceUsers.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val currentUser = firebaseAuth?.currentUser ?: return
                for (data in snapshot.children){
                    val classUser = data.getValue(User::class.java) ?: return
                    if (classUser.id == currentUser.uid){
                        classUser.let {
                            _userInfo.value = it
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    fun signOut(){
        firebaseAuth?.signOut()
    }
}