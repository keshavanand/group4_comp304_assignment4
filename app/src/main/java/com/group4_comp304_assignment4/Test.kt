package com.group4_comp304_assignment4

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_table")
data class Test(
    @PrimaryKey(autoGenerate = true)
    val testId: Long = 0,
    val patientId: Long,
    val nurseId: Long,
    val BPL: Double,
    val BPH: Double,
    val temperature: Double
)