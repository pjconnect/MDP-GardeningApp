package com.pjone.gardeningjournal.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.pjone.gardeningjournal.db.PlantRepository

class UpdatePlantVM(app: Application, id: Int) : AndroidViewModel(app) {
    val repo = PlantRepository(app)
    val plant = repo.getPlantById(id);
}