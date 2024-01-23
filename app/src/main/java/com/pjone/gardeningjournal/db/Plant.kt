package com.pjone.gardeningjournal.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "plants")
@Parcelize
class Plant(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type: String,
    val wateringFrequency: Int,
    val plantingDate: String
) : Parcelable {
}