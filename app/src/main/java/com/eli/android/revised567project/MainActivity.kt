package com.eli.android.revised567project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var menuStartButton: Button
    private lateinit var menuHelpButton: Button
    private lateinit var menuQuitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuStartButton = findViewById(R.id.menu_start_button)
        menuHelpButton = findViewById(R.id.menu_help_button)
        menuQuitButton = findViewById(R.id.menu_quit_button)

        menuStartButton.setOnClickListener{
            val intent = Intent(this, LanguageSelect::class.java)
            startActivity(intent)
        }
    }
}
