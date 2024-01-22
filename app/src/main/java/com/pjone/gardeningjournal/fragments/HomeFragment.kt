package com.pjone.gardeningjournal.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pjone.gardeningjournal.R
import com.pjone.gardeningjournal.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.button3.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_addPlantsFragment)
        }

        binding.button2.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_allPlanetsFragment)
        }

        return binding.root
    }
}