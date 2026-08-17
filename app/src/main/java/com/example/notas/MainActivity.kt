package com.example.notas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val noteInput = findViewById<EditText>(R.id.noteInput)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val note = noteInput.text.toString().trim()

            if (note.isNotEmpty()) {
                Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show()
                noteInput.text.clear()
            } else {
                Toast.makeText(this, "Escribí una nota primero", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
