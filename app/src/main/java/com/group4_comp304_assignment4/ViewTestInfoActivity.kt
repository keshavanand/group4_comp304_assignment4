package com.group4_comp304_assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LiveData

class ViewTestInfoActivity : AppCompatActivity(), TestDao {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_test_info)

    }
    fun searchTestResults(view: View) {
        //instantiation of buttons, and text.
        val inputEditText = findViewById<EditText>(R.id.inputEditText)
        val value1 = findViewById<TextView>(R.id.variable1TextView)
        val value2 = findViewById<TextView>(R.id.variable2TextView)
        val value3 = findViewById<TextView>(R.id.variable3TextView)
        val value4 = findViewById<TextView>(R.id.variable4TextView)
        val value5 = findViewById<TextView>(R.id.variable5TextView)
        // Get the text entered by the user
        val userInput = inputEditText.text.toString()
        // Convert from string, to Long
        val patientId = userInput.toLong()

        // Database function, return test for patient ID
        //getTestsForPatient(patientId)

        //assigning results of the test variables to the appropriate places
        value1.text = "Patient ID: $userInput"
        val val2 = "Nurse ID: "
        value2.text = val2
        val val3 = "BPH:  "
        value3.text = val3
        val val4 = "BPL:  "
        value4.text = val4
        val val5 = "Temperature:  "
        value5.text = val5
    }

    override fun insertTest(test: Test) {
        TODO("Not yet implemented")
    }

    override fun getAllTests(): LiveData<List<Test>> {
        TODO("Not yet implemented")
    }

    override fun getTestsForPatient(patientId: Long): LiveData<List<Test>> {
        TODO("Not yet implemented")
    }

    override fun updateTest(test: Test) {
        TODO("Not yet implemented")
    }

    override fun deleteTest(test: Test) {
        TODO("Not yet implemented")
    }

    override fun deleteAllTest() {
        TODO("Not yet implemented")
    }


}