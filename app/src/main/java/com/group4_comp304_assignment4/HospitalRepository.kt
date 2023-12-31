package com.group4_comp304_assignment4

import androidx.lifecycle.LiveData
import androidx.room.Query

class HospitalRepository(private val patientDao: PatientDao, private val testDao: TestDao, private val nurseDao: NurseDao) {

    // Patient operations
    fun insertPatient(patient: Patient) {
        patientDao.insertPatient(patient)
    }

    fun getAllPatients(): LiveData<List<Patient>> {
        return patientDao.getAllPatients()
    }

    fun getPatientById(patientId: Long): LiveData<Patient?> {
        return patientDao.getPatientById(patientId)
    }

    fun updatePatient(patient: Patient) {
        patientDao.updatePatient(patient)
    }

    fun deletePatient(patient: Patient) {
        patientDao.deletePatient(patient)
    }
    fun deleteAllPatients(){
        patientDao.deleteAllPatients()
    }

    // Test operations
    fun insertTest(test: Test) {
        testDao.insertTest(test)
    }

    fun getAllTests(): LiveData<List<Test>> {
        return testDao.getAllTests()
    }

    fun getTestsForPatient(patientId: Long): LiveData<List<Test>> {
        return testDao.getTestsForPatient(patientId)
    }

    fun updateTest(test: Test) {
        testDao.updateTest(test)
    }

    fun deleteTest(test: Test) {
        testDao.deleteTest(test)
    }
    fun deleteAllTest(){
        testDao.deleteAllTest()
    }

    // Nurse operations
    fun insertNurse(nurse: Nurse) {
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

    fun updateNurse(nurse: Nurse) {
        nurseDao.updateNurse(nurse)
    }

    fun deleteNurse(nurse: Nurse) {
        nurseDao.deleteNurse(nurse)
    }
    fun deleteAllNurse(){
        nurseDao.deleteAllNurse()
    }

}
