package com.eli.android.revised567project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class LanguageSelect : AppCompatActivity() {

    private lateinit var cSharpeButton: Button
    private lateinit var pythonButton: Button
    private lateinit var javaScriptButton: Button
    private lateinit var cppButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.language_select)

        cSharpeButton = findViewById(R.id.csharpe)
        javaScriptButton = findViewById(R.id.javascript)
        pythonButton = findViewById(R.id.python)
        cppButton = findViewById(R.id.cpp)

        cSharpeButton.setOnClickListener {
            val intent = Intent(this,DifficultySelect::class.java)
            val name = "C#"
            intent.putExtra("language", name)
            startActivityForResult(intent,0)
        }

        javaScriptButton.setOnClickListener {
            val intent = Intent(this,DifficultySelect::class.java)
            val name = "JavaScript"
            intent.putExtra("language", name)
            startActivityForResult(intent,0)
        }

        pythonButton.setOnClickListener {
            val intent = Intent(this,DifficultySelect::class.java)
            val name = "Python"
            intent.putExtra("language", name)
            startActivityForResult(intent,0)
        }

        cppButton.setOnClickListener{
            val intent = Intent(this,DifficultySelect::class.java)
            val name = "CPP"
            intent.putExtra("language",name)
            startActivityForResult(intent,0)
        }
    }

}