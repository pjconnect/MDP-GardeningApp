package com.pjone.gardeningjournal.fragments.list_view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pjone.gardeningjournal.db.PlantRepository
import kotlinx.coroutines.launch

class PlantsVM(app: Application) : AndroidViewModel(app) {
    val repo = PlantRepository(app)
    var plantList = repo.allPlants;
}