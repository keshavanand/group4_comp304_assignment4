package com.group4_comp304_assignment4

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patient_table")
class Patient(
    @PrimaryKey(autoGenerate = true)
    val patientId: Long = 0,
    val firstname: String,
    val lastname: String,
    val department: String,
    val nurseId: Long,
    val room: String
)