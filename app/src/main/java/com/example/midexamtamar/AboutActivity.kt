package com.example.midexamtamar

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_activity)

        val titleTextView: TextView = findViewById(R.id.textView4)
        val descriptionTextView: TextView = findViewById(R.id.textView)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")

        titleTextView.text = name
        descriptionTextView.text = description
    }
}