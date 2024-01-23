package com.pjone.gardeningjournal.fragments.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pjone.gardeningjournal.db.Plant
import com.pjone.gardeningjournal.db.PlantRepository
import kotlinx.coroutines.launch

class AddPlantsVM(app: Application) : AndroidViewModel(app) {

    val repo = PlantRepository(app);

    fun addPlant(plant: Plant){
        viewModelScope.launch {
            repo.insert(plant)
        }
    }

}