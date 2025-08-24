package com.example.bubbleobd2

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var txtSpeed: TextView
    private lateinit var txtRpm: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtSpeed = findViewById(R.id.txtSpeed)
        txtRpm = findViewById(R.id.txtRpm)

        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            if (!Settings.canDrawOverlays(this)) {
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                startActivity(intent)
            } else {
                startService(Intent(this, FloatingService::class.java))
            }
        }

        // demo dữ liệu
        txtSpeed.text = "Speed: 60 km/h"
        txtRpm.text = "RPM: 2500"
    }
}
