package com.pjone.gardeningjournal.fragments

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.pjone.gardeningjournal.databinding.FragmentUpdatePlantBinding

class UpdatePlant : Fragment() {
    val args by navArgs<UpdatePlantArgs>()
    lateinit var binding: FragmentUpdatePlantBinding;
    private lateinit var vm: UpdatePlantVM;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdatePlantBinding.inflate(layoutInflater)

        val items = arrayOf("Flower", "Vegetable", "Herb", "Other")
        val adapter = ArrayAdapter<String>(requireContext(), R.layout.simple_list_item_1, items)
        binding.spinnerUpdatePlantTypes.adapter = adapter;

        binding.txtUpdatePlantName.setText(args.selectedPlant.name)
        binding.txtUpdateDatePlanted.setText(args.selectedPlant.plantingDate)
        binding.spinnerUpdatePlantTypes.setSelection(items.indexOf(args.selectedPlant.type))
        binding.txtUWaterFQ.setText(args.selectedPlant.wateringFrequency.toString())

        return binding.root;
    }

}