package com.pjone.gardeningjournal.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pjone.gardeningjournal.R
import com.pjone.gardeningjournal.db.Plant

class PlantsRecyclerAdapter() : RecyclerView.Adapter<PlantsRecyclerAdapter.ViewHolder>()
{
    var plantList: List<Plant> = emptyList()
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rcDate = itemView.findViewById<TextView>(R.id.rcPlantDate)
        var rcName = itemView.findViewById<TextView>(R.id.rcPlantName)
        var rcType = itemView.findViewById<TextView>(R.id.rcPlantType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false);
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return plantList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plant = plantList[position];

        holder.rcName.setText(plant.name)
        holder.rcDate.setText(plant.plantingDate)
        holder.rcType.setText(plant.type)
    }

    fun setData(plantList: List<Plant>){
        this.plantList = plantList;
        notifyDataSetChanged()
    }

}