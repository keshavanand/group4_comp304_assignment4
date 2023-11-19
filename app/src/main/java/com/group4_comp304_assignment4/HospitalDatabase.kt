package com.group4_comp304_assignment4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Patient::class, Test::class, Nurse::class], version = 1)
abstract class HospitalDatabase : RoomDatabase() {

    abstract fun patientDao(): PatientDao
    abstract fun testDao(): TestDao
    abstract fun nurseDao(): NurseDao

    companion object {
        @Volatile
        private var INSTANCE: HospitalDatabase? = null

        fun getDatabase(context: Context): HospitalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HospitalDatabase::class.java,
                    "hospital_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
