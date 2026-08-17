package com.example.notas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var noteStorage: NoteStorage
    private lateinit var noteInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteStorage = NoteStorage(this)

        noteInput = findViewById(R.id.noteInput)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        val content = noteInput.text.toString().trim()

        if (content.isEmpty()) {
            Toast.makeText(
                this,
                "Escribí una nota primero",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val notes = noteStorage.getNotes()

        val newNote = Note(
            id = System.currentTimeMillis(),
            title = "Nota ${notes.size + 1}",
            content = content
        )

        notes.add(newNote)
        noteStorage.saveNotes(notes)

        noteInput.text.clear()

        Toast.makeText(
            this,
            "Nota guardada",
            Toast.LENGTH_SHORT
        ).show()
    }
}
