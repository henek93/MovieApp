package com.example.movieapp.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "This is main Fragment"
    }
    val text: LiveData<String> = _text


}