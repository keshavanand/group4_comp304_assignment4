package com.group4_comp304_assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Define methods to open other activities

    fun openPatientActivity(view: View) {
        startActivity(Intent(this, PatientActivity::class.java))
    }

    fun openTestActivity(view: View) {
        startActivity(Intent(this, TestActivity::class.java))
    }

    fun openViewTestInfoActivity(view: View) {
        startActivity(Intent(this, ViewTestInfoActivity::class.java))
    }

    fun openUpdateInfoActivity(view: View) {
        startActivity(Intent(this, UpdateInfoActivity::class.java))
    }
}

