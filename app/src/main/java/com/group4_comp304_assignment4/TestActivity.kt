package com.group4_comp304_assignment4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts

const val TEST_ID = " com.example.group4_comp304_assignment4.TEST_ID"
const val PATIENT_ID = " com.example.group4_comp304_assignment4.PATIENT_ID"
const val NURSE_ID = " com.example.group4_comp304_assignment4.NURSE_ID"
const val BPL = " com.example.group4_comp304_assignment4.BPL"
const val BPH = " com.example.group4_comp304_assignment4.BPH"
const val TEMPERATURE = " com.example.group4_comp304_assignment4.TEMPERATURE"

class TestActivity : AppCompatActivity() {
    private var nurseId = -1L
    private var patientId = -1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        // get the nurseId id
        val appPref = getSharedPreferences((application as HospitalApplication).PREF_NAME, MODE_PRIVATE) ?: return
        nurseId = appPref.getLong((application as HospitalApplication).PREF_NURSE_ID, -1)


    }

    private val updateResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->

            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data

                if (data != null) {

                    // get the data
                    val testId = data.getLongExtra(TEST_ID, 0)
                    val bpl = data.getDoubleExtra(BPL, -1.0)
                    val bph = data.getDoubleExtra(BPH, -1.0)
                    val temperature = data.getDoubleExtra(TEMPERATURE, -1.0)

                    var test = Test(
                        testId,
                        patientId,
                        nurseId,
                        bpl,
                        bph,
                        temperature
                    )

                } else {
                    //
                }
            }
        }
}