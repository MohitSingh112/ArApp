package com.example.arapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DrillDetailActivity : AppCompatActivity() {

    private lateinit var drillImage: ImageView
    private lateinit var drillTitle: TextView
    private lateinit var drillDescription: TextView
    private lateinit var drillTips: TextView
    private lateinit var startARButton: Button

    private var drillIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drill_detail)

        drillIndex = intent.getIntExtra("DRILL_INDEX", 0)

        setupViews()
        loadDrillData()
        setupClickListeners()
    }

    private fun setupViews() {
        drillImage = findViewById(R.id.drillImage)
        drillTitle = findViewById(R.id.drillTitle)
        drillDescription = findViewById(R.id.drillDescription)
        drillTips = findViewById(R.id.drillTips)
        startARButton = findViewById(R.id.startARDrillButton)
    }

    private fun loadDrillData() {
        when (drillIndex) {
            0 -> {
                drillImage.setImageResource(R.drawable.ic_drill_1)
                drillTitle.text = "Drill 1 - Basic Placement"
                drillDescription.text = "This is a basic placement drill where you'll learn to place objects on detected surfaces. Perfect for beginners to understand AR placement mechanics."
                drillTips.text = "Tips:\n• Make sure you have good lighting\n• Move your phone slowly to detect surfaces\n• Tap once to place the marker"
            }
            1 -> {
                drillImage.setImageResource(R.drawable.ic_drill_2)
                drillTitle.text = "Drill 2 - Advanced Placement"
                drillDescription.text = "Advanced placement drill with multiple object positioning. You'll practice precise placement and spatial awareness in AR."
                drillTips.text = "Tips:\n• Try different angles for better placement\n• Use steady hands for accuracy\n• Practice placing objects at different distances"
            }
            2 -> {
                drillImage.setImageResource(R.drawable.ic_drill_3)
                drillTitle.text = "Drill 3 - Expert Placement"
                drillDescription.text = "Expert level drill for mastering AR object placement. This drill challenges your precision and understanding of AR space."
                drillTips.text = "Tips:\n• Master quick surface detection\n• Place objects with pinpoint accuracy\n• Challenge yourself with difficult angles"
            }
        }
    }

    private fun setupClickListeners() {
        startARButton.setOnClickListener {
            val intent = Intent(this, ARActivity::class.java)
            intent.putExtra("DRILL_INDEX", drillIndex)
            startActivity(intent)
        }
    }
}