package com.example.notas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val newNotebookButton =
            findViewById<Button>(R.id.newNotebookButton)

        val notebookCard =
            findViewById<LinearLayout>(R.id.notebookCard)

        val openNotebook = {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        newNotebookButton.setOnClickListener {
            openNotebook()
        }

        notebookCard.setOnClickListener {
            openNotebook()
        }
    }
}
