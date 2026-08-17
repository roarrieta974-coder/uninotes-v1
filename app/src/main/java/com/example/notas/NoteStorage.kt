package com.example.notas

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class NoteStorage(context: Context) {

    private val preferences = context.getSharedPreferences(
        "uninotes_preferences",
        Context.MODE_PRIVATE
    )

    private val notesKey = "notes"

    fun getNotes(): MutableList<Note> {
        val notes = mutableListOf<Note>()
        val json = preferences.getString(notesKey, "[]") ?: "[]"

        val array = JSONArray(json)

        for (i in 0 until array.length()) {
            val objectNote = array.getJSONObject(i)

            notes.add(
                Note(
                    id = objectNote.getLong("id"),
                    title = objectNote.getString("title"),
                    content = objectNote.getString("content")
                )
            )
        }

        return notes
    }

    fun saveNotes(notes: List<Note>) {
        val array = JSONArray()

        notes.forEach { note ->
            val objectNote = JSONObject()

            objectNote.put("id", note.id)
            objectNote.put("title", note.title)
            objectNote.put("content", note.content)

            array.put(objectNote)
        }

        preferences.edit()
            .putString(notesKey, array.toString())
            .apply()
    }
}
