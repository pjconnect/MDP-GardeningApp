package com.pjone.gardeningjournal.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjone.gardeningjournal.databinding.FragmentAllPlanetsBinding

class AllPlanetsFragment : Fragment() {
    private lateinit var binding : FragmentAllPlanetsBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllPlanetsBinding.inflate(layoutInflater)
        return binding.root;
    }
}