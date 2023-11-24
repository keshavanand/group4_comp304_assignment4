package com.group4_comp304_assignment4

import androidx.lifecycle.LiveData
import androidx.room.Query

class HospitalRepository(private val patientDao: PatientDao, private val testDao: TestDao, private val nurseDao: NurseDao) {

    // Patient operations
    suspend fun insertPatient(patient: Patient) {
        patientDao.insertPatient(patient)
    }

    fun getAllPatients(): LiveData<List<Patient>> {
        return patientDao.getAllPatients()
    }

    fun getPatientById(patientId: Long): LiveData<Patient?> {
        return patientDao.getPatientById(patientId)
    }

    suspend fun updatePatient(patient: Patient) {
        patientDao.updatePatient(patient)
    }

    suspend fun deletePatient(patient: Patient) {
        patientDao.deletePatient(patient)
    }
    suspend fun deleteAllPatients(){
        patientDao.deleteAllPatients()
    }

    // Test operations
    suspend fun insertTest(test: Test) {
        testDao.insertTest(test)
    }

    fun getAllTests(): LiveData<List<Test>> {
        return testDao.getAllTests()
    }

    suspend fun getTestsForPatient(patientId: Long): LiveData<List<Test>> {
        return testDao.getTestsForPatient(patientId)
    }

    suspend fun updateTest(test: Test) {
        testDao.updateTest(test)
    }

    suspend fun deleteTest(test: Test) {
        testDao.deleteTest(test)
    }

    suspend fun deleteAllTest(){
        testDao.deleteAllTest()
    }
    // Nurse operations
    suspend fun insertNurse(nurse: Nurse) {
        nurseDao.insertNurse(nurse)
    }

    fun getAllNurses(): LiveData<List<Nurse>> {
        return nurseDao.getAllNurses()
    }

    fun getNurseById(nurseId: Long): LiveData<Nurse?> {
        return nurseDao.getNurseById(nurseId)
    }

    fun getNurseByIdAndPassword(nurseId: Long, password: String): LiveData<Nurse?> {
        return nurseDao.getNurseByIdAndPassword(nurseId,password)
    }

    suspend fun updateNurse(nurse: Nurse) {
        nurseDao.updateNurse(nurse)
    }

    suspend fun deleteNurse(nurse: Nurse) {
        nurseDao.deleteNurse(nurse)
    }
    suspend fun deleteAllNurse(){
        nurseDao.deleteAllNurse()
    }
}
