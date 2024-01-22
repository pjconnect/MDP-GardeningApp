package com.pjone.gardeningjournal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pjone.gardeningjournal.databinding.FragmentAddPlantsBinding
import com.pjone.gardeningjournal.R
import com.pjone.gardeningjournal.db.Plant


class AddPlantsFragment : Fragment() {
    private lateinit var binding: FragmentAddPlantsBinding
    private lateinit var vm: AddPlantsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddPlantsBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this).get(AddPlantsViewModel::class.java)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        activity?.setTitle("Add Plant Info")
//        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)



        binding.btnAdd.setOnClickListener {
//            vm.addPlant(Plant(0, binding.txtPlantName, "", 1, ""))
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                findNavController().navigate(R.id.action_addPlantsFragment_to_homeFragment)
            }
        }
        return false
    }
}