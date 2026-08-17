package com.example.notas

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var drawingView: DrawingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawingView)

        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            Toast.makeText(
                this,
                "Página lista para guardar",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
