package com.pjone.gardeningjournal.fragments.list_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.pjone.gardeningjournal.R
import com.pjone.gardeningjournal.db.Plant

class PlantsRecyclerAdapter() : RecyclerView.Adapter<PlantsRecyclerAdapter.MyViewHolder>()
{
    var plantList: List<Plant> = emptyList()
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rcDate = itemView.findViewById<TextView>(R.id.rcPlantDate)
        var rcName = itemView.findViewById<TextView>(R.id.rcPlantName)
        var rcType = itemView.findViewById<TextView>(R.id.rcPlantType)
        var itemRow = itemView.findViewById<ConstraintLayout>(R.id.plantRow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false);
        return MyViewHolder(view);
    }

    override fun getItemCount(): Int {
        return plantList.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val plant = plantList[position];

        holder.rcName.setText(plant.name)
        holder.rcDate.setText(plant.plantingDate)
        holder.rcType.setText(plant.type)
        holder.itemRow.setOnClickListener{
            val action = PlantsFragmentDirections.actionPlantsFragmentToUpdatePlant(plant)
            holder.itemView.findNavController().navigate(action);
        }
    }

    fun setData(plantList: List<Plant>){
        this.plantList = plantList;
        notifyDataSetChanged()
    }

}