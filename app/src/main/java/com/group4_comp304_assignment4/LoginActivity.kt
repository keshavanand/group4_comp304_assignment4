package com.group4_comp304_assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var etNurseId: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    private lateinit var hospitalRepository: HospitalRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etNurseId = findViewById(R.id.etNurseId)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        hospitalRepository = (application as HospitalApplication).repository

        btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val nurseId = etNurseId.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // Validate nurse credentials using Room database
        // You may want to run this in a background thread or use a coroutine
        // For simplicity, this example assumes you're running it on the main thread

        lifecycleScope.launch(Dispatchers.Main) {
            if (nurseId.isNotEmpty() && password.isNotEmpty()) {
                val nurse = hospitalRepository.getNurseByIdAndPassword(nurseId.toLong(), password)

                if (nurse != null) {
                    // Nurse credentials are valid, proceed to the next activity
                    val intent = Intent(this@LoginActivity, PatientActivity::class.java)
                    startActivity(intent)
                    finish() // Prevent going back to the login screen
                } else {
                    showToast("Invalid nurse ID or password")
                }
            } else {
                showToast("Please enter nurse ID and password")
            }
        }
    }

    // Utility method to show toast (Replace with your actual implementation)
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
