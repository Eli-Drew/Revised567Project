package com.eli.android.revised567project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
private const val LANGUAGE = "language"
private const val DIFFICULTY = "difficulty"

class DifficultySelect : AppCompatActivity() {

    private lateinit var easyButton: Button
    private lateinit var mediumButton: Button
    private lateinit var hardButton: Button
    private lateinit var prodigyButton: Button
    private var language= "no language selected"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.difficulty_select)

        easyButton = findViewById(R.id.easy_button)
        mediumButton = findViewById(R.id.medium_button)
        hardButton = findViewById(R.id.hard_button)
        prodigyButton = findViewById(R.id.prodigy_button)

        val language = intent.getStringExtra("language")

        easyButton.setOnClickListener{
            val intent = Intent(this,QuestionActivity::class.java)
            val name: String = "Easy"
            intent.putExtra("difficulty",name)
            intent.putExtra("language", language)
            startActivityForResult(intent,0)
        }

        mediumButton.setOnClickListener{
            val intent = Intent(this,QuestionActivity::class.java)
            val name = "Medium"
            intent.putExtra("difficulty", name)
            intent.putExtra("language", language)
            startActivityForResult(intent,0)
        }

        hardButton.setOnClickListener {
            val intent = Intent(this,QuestionActivity::class.java)
            val name = "Hard"
            intent.putExtra("difficulty", name)
            intent.putExtra("language", language)
            startActivityForResult(intent,0)
        }

        prodigyButton.setOnClickListener{
            val intent = Intent(this,QuestionActivity::class.java)
            val name = "Prodigy"
            intent.putExtra("difficulty", name)
            intent.putExtra("language", language)
            //startActivityForResult(intent,0)
            startActivity(intent)
        }
    }
}