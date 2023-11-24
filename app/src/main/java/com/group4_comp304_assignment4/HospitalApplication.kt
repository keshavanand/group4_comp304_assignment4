package com.group4_comp304_assignment4

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class HospitalApplication: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { HospitalDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { HospitalRepository(database.patientDao(),database.testDao(),database.nurseDao()) }
}