package com.group4_comp304_assignment4

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PatientDao {
    @Insert
    fun insertPatient(patient: Patient): Long

    @Query("SELECT * FROM patient_table")
    fun getAllPatients(): LiveData<List<Patient>>

    @Query("SELECT * FROM patient_table WHERE patientId = :patientId")
    fun getPatientById(patientId: Long): LiveData<Patient?>

    @Update
    suspend fun updatePatient(patient: Patient)

    @Delete
    suspend fun deletePatient(patient: Patient)

}
