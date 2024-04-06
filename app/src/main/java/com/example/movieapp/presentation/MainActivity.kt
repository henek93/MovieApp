package com.example.movieapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.presentation.ui.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragment_layout, ProfileFragment.newInstanceProfileFragment())
//            .addToBackStack(null)
//            .commit()


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.fragment_layout)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


        navView.setupWithNavController(navController)
    }
}