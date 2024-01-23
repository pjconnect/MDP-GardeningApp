package com.pjone.gardeningjournal.fragments

import android.widget.ArrayAdapter
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pjone.gardeningjournal.databinding.FragmentAddPlantsBinding
import com.pjone.gardeningjournal.db.Plant


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
        binding.spinnerPlantTypes.adapter = adapter;

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {
            addPlant();
        }
    }

    private fun addPlant() {
        val plantName = binding.txtPlantName.text.toString();
        val plantedDate = binding.txtDatePlanted.text.toString();
        val plantType = binding.spinnerPlantTypes.selectedItem.toString()
        val waterFrequency  = binding.txtWaterFQ.text.toString().toIntOrNull()

        //validate
        if(TextUtils.isEmpty(plantName) || TextUtils.isEmpty(plantedDate) || waterFrequency == null){
            Toast.makeText(requireContext(), "Please fill all the fields!", Toast.LENGTH_LONG).show()
            return;
        }

        vm.addPlant(Plant(0, plantName, plantType, waterFrequency, plantedDate ));
        Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()

        binding.txtPlantName.setText("");
        binding.txtDatePlanted.setText("");
        binding.txtWaterFQ.setText("");
    }
}