package com.group4_comp304_assignment4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

const val U_PATIENT_ID = " com.example.group4_comp304_assignment4.U_PATIENT_ID"
const val FIRSTNAME = " com.example.group4_comp304_assignment4.FIRSTNAME"
const val LASTNAME = " com.example.group4_comp304_assignment4.LASTNAME"
const val U_NURSE_ID = " com.example.group4_comp304_assignment4.U_NURSE_ID"
const val DEPARTMENT = " com.example.group4_comp304_assignment4.DEPARTMENT"
const val ROOM = " com.example.group4_comp304_assignment4.ROOM"
class UpdateInfoActivity : AppCompatActivity() {
    private var patientId: Long = -1L
    private var nurseId:Long = -1L
    private lateinit var etFirstname: EditText
    private lateinit var etLastname: EditText
    private lateinit var etNurseId: EditText
    private lateinit var etDepartment: EditText
    private lateinit var etRoom: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_info)

        //views
        etFirstname = findViewById(R.id.etFirstName)
        etLastname = findViewById(R.id.etLastName)
        etNurseId = findViewById(R.id.etNurseId)
        etDepartment = findViewById(R.id.etDepartment)
        etRoom = findViewById(R.id.etRoom)
        val btnSave = findViewById<Button>(R.id.btnSave)

        etFirstname.setText(intent.getStringExtra(FIRSTNAME))
        etLastname.setText(intent.getStringExtra(LASTNAME))
        etNurseId.setText(intent.getStringExtra(U_NURSE_ID))
        etDepartment.setText(intent.getStringExtra(DEPARTMENT))
        etRoom.setText(intent.getStringExtra(ROOM))

        btnSave.setOnClickListener {
            savePatient()
        }
    }

    private fun savePatient() {
        val firstname = etFirstname.text.trim().toString()
        val lastname = etLastname.text.trim().toString()
        val department = etDepartment.text.trim().toString()
        val room = etRoom.text.trim().toString()

        // data validation
        if (firstname.isEmpty() || lastname.isEmpty() || department.isEmpty() || room.isEmpty()) {
            Toast.makeText(this, "please fill in information", Toast.LENGTH_SHORT).show()
            return
        }

        // pass data to activity
        val data = Intent()
        data.putExtra(PATIENT_ID, patientId)
        data.putExtra(FIRSTNAME, firstname)
        data.putExtra(LASTNAME, lastname)
        data.putExtra(DEPARTMENT, department)
        data.putExtra(ROOM, room)
        setResult(Activity.RESULT_OK, data)
        finish()
    }
}