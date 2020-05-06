package com.eli.android.revised567project

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HelpActivity : AppCompatActivity() {

    private lateinit var homeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.help_activity)

        homeButton = findViewById(R.id.help_home_return)

        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
        }
    }
}