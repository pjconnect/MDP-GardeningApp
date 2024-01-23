package com.pjone.gardeningjournal.fragments.update

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pjone.gardeningjournal.db.Plant
import com.pjone.gardeningjournal.db.PlantRepository
import kotlinx.coroutines.launch

class UpdatePlantVM(app: Application) : AndroidViewModel(app) {
    val repo = PlantRepository(app)
    fun deletePlant(id: Int) {
        viewModelScope.launch {
            repo.delete(id)
        }
    }

    fun updatePlant(plant: Plant){
        viewModelScope.launch {
            repo.update(plant)
        }
    }

}