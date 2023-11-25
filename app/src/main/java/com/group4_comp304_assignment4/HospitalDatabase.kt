package com.group4_comp304_assignment4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Patient::class, Test::class, Nurse::class], version = 1)
abstract class HospitalDatabase : RoomDatabase() {

    abstract fun patientDao(): PatientDao
    abstract fun testDao(): TestDao
    abstract fun nurseDao(): NurseDao

    private class HospitalDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(
                        database.patientDao(),
                        database.testDao(),
                        database.nurseDao()
                    )
                }
            }
        }

        suspend fun populateDatabase(
            patientDao: PatientDao,
            testDao: TestDao,
            nurseDao: NurseDao
        ) {
            // Delete all content here.
            patientDao.deleteAllPatients()
            testDao.deleteAllTest()
            nurseDao.deleteAllNurse()

            // Add sample data.
            val patient = Patient(firstname = "John", lastname = "Doe", department = "Cardiology", nurseId = 1, room = "101")
            patientDao.insertPatient(patient)

            val test = Test(patientId = 1, nurseId = 1, BPL = 120.0, BPH = 80.0, temperature = 98.6)
            testDao.insertTest(test)

            val nurse = Nurse(nurseId = 1, firstname = "Nurse", lastname = "Smith", department = "Cardiology", password = "password123")
            nurseDao.insertNurse(nurse)


        }
    }

    companion object {
        @Volatile
        private var INSTANCE: HospitalDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): HospitalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HospitalDatabase::class.java,
                    "hospital_database"
                )
                    .addCallback(HospitalDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
