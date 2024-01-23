package com.pjone.gardeningjournal.fragments

import android.widget.ArrayAdapter
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pjone.gardeningjournal.databinding.FragmentAddPlantsBinding
import com.pjone.gardeningjournal.db.Plant
import com.pjone.gardeningjournal.R

class AddPlantsFragment : Fragment() {
    private lateinit var binding: FragmentAddPlantsBinding
    private lateinit var vm: AddPlantsVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddPlantsBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this).get(AddPlantsVM::class.java)

        val items = arrayOf("Flower", "Vegetable", "Herb", "Other")
        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, items)
        binding.spinnerPlantTypes.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveAdd.setOnClickListener {
            addPlant()

            binding.spinnerPlantTypes.setSelection(0)
            binding.txtPlantName.setText("")
            binding.txtDatePlanted.setText("")
            binding.txtWaterFQ.setText("")
        }

        binding.btnSaveClose.setOnClickListener{
            addPlant()
            findNavController().navigate(R.id.action_addPlantsFragment_to_plantsFragment)
        }
    }

    private fun addPlant() {
        val plantName = binding.txtPlantName.text.toString()
        val plantedDate = binding.txtDatePlanted.text.toString()
        val plantType = binding.spinnerPlantTypes.selectedItem.toString()
        val waterFrequency  = binding.txtWaterFQ.text.toString().toIntOrNull()

        //validate
        if(TextUtils.isEmpty(plantName) || TextUtils.isEmpty(plantedDate) || waterFrequency == null){
            Toast.makeText(requireContext(), "Please fill all the fields!", Toast.LENGTH_LONG).show()
            return
        }

        vm.addPlant(Plant(0, plantName, plantType, waterFrequency, plantedDate ))
        Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()
    }
}