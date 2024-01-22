package com.pjone.gardeningjournal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Plant::class], version = 1)
abstract class PlantDatabase : RoomDatabase() {
    abstract fun plantDao(): PlantDao

    companion object {
        @Volatile
        private var INSTANCE: PlantDatabase? = null

        fun getDatabase(context: Context): PlantDatabase {
            var tmpInstance = INSTANCE;
            if (tmpInstance != null)
                return tmpInstance;

            tmpInstance = Room.databaseBuilder(
                context.applicationContext, PlantDatabase::class.java, "plant_database"
            ).build()

            INSTANCE = tmpInstance;
            return tmpInstance;
        }
    }

}