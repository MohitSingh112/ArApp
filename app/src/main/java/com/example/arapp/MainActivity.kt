package com.example.arapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var drillSpinner: Spinner
    private lateinit var startARButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        setupDrillSpinner()
        setupClickListeners()
    }

    private fun setupViews() {
        drillSpinner = findViewById(R.id.drillSpinner)
        startARButton = findViewById(R.id.startARButton)
    }

    private fun setupDrillSpinner() {
        val drills = arrayOf("Drill 1 - Basic Placement", "Drill 2 - Advanced Placement", "Drill 3 - Expert Placement")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, drills)
        drillSpinner.adapter = adapter
    }

    private fun setupClickListeners() {
        startARButton.setOnClickListener {
            val selectedDrillIndex = drillSpinner.selectedItemPosition
            val intent = Intent(this, DrillDetailActivity::class.java)
            intent.putExtra("DRILL_INDEX", selectedDrillIndex)
            startActivity(intent)
        }
    }
}