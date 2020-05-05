package com.eli.android.revised567project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

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
        } // end  of menuStartButton

        menuHelpButton.setOnClickListener {
            val intent = Intent()
            startActivity(intent)
        } // end of menuHelpButton

        menuQuitButton.setOnClickListener {
//            onFinishedClick()
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags((Intent.FLAG_ACTIVITY_NEW_TASK))
            startActivity(intent)
            finish()

        } // end of menuQuitButton

    } // end of override fun onCreate

} // end of class

