package com.group4_comp304_assignment4

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nurse_table")
data class Nurse(
    @PrimaryKey(autoGenerate = true)
    val nurseId: Long = 0,
    val firstname: String,
    val lastname: String,
    val department: String,
    val password: String
)