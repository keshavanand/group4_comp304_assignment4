package com.group4_comp304_assignment4

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HospitalViewModel(private val repository: HospitalRepository) : ViewModel() {

    // Patient operations
    val allPatients: LiveData<List<Patient>> = repository.getAllPatients()

    fun insertPatient(patient: Patient) {
        viewModelScope.launch {
            repository.insertPatient(patient)
        }
    }

    suspend fun getPatientById(patientId: Long): LiveData<Patient> {
        return repository.getPatientById(patientId)
    }

    fun updatePatient(patient: Patient) {
        viewModelScope.launch {
            repository.updatePatient(patient)
        }
    }

    fun deletePatient(patient: Patient) {
        viewModelScope.launch {
            repository.deletePatient(patient)
        }
    }

    // Test operations
    val allTests: LiveData<List<Test>> = repository.getAllTests()

    fun insertTest(test: Test) {
        viewModelScope.launch {
            repository.insertTest(test)
        }
    }

    suspend fun getTestsForPatient(patientId: Long): LiveData<List<Test>> {
        return repository.getTestsForPatient(patientId)
    }

    fun updateTest(test: Test) {
        viewModelScope.launch {
            repository.updateTest(test)
        }
    }

    fun deleteTest(test: Test) {
        viewModelScope.launch {
            repository.deleteTest(test)
        }
    }

    // Nurse operations
    val allNurses: LiveData<List<Nurse>> = repository.getAllNurses()

    fun insertNurse(nurse: Nurse) {
        viewModelScope.launch {
            repository.insertNurse(nurse)
        }
    }

    suspend fun getNurseById(nurseId: Long): LiveData<Nurse> {
        return repository.getNurseById(nurseId)
    }

    fun updateNurse(nurse: Nurse) {
        viewModelScope.launch {
            repository.updateNurse(nurse)
        }
    }

    fun deleteNurse(nurse: Nurse) {
        viewModelScope.launch {
            repository.deleteNurse(nurse)
        }
    }
}

class HospitalViewModelFactory(private val repository: HospitalRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HospitalViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HospitalViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
