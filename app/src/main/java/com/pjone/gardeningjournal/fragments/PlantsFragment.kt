package com.pjone.gardeningjournal.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pjone.gardeningjournal.R
import com.pjone.gardeningjournal.databinding.FragmentPlantsBinding

class PlantsFragment : Fragment() {
    private lateinit var binding : FragmentPlantsBinding;
    private lateinit var vm: PlantsVM;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlantsBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this).get(PlantsVM::class.java)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PlantsRecyclerAdapter();
        binding.recyclerView.adapter = adapter;
        vm.plantList.observe(viewLifecycleOwner, Observer { items ->
            adapter.setData(items);
        })

        binding.btnFloatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_plantsFragment_to_addPlantsFragment)
        }
    }
}