package com.pjone.gardeningjournal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupActionBarWithNavController
import com.pjone.gardeningjournal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navHostFragment = supportFragmentManager.findFragmentById(androidx.navigation.fragment.R.)
//        navController = navHostFragment.navController
//
//        navController = navHostFragment.findNavController()
//        setupActionBarWithNavController(findNavController(navHostFragment.))

//        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))
    }
}