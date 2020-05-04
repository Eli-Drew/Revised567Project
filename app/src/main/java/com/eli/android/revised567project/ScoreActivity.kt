package com.eli.android.revised567project

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.round

private const val CORRECT_MULTIPLIER = 100
private const val  TIME_MULTIPLIER = 10

class ScoreActivity : AppCompatActivity() {

    private lateinit var homeButton: Button
    private lateinit var correct: TextView
    private lateinit var possible: TextView
//    time
    private lateinit var points: TextView


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.score_layout)

        correct = findViewById(R.id.correct_text_view)
        possible = findViewById(R.id.possible_text_view)
        points = findViewById(R.id.score_points_text_view)

        val userScore = intent.getDoubleExtra(SCORE,0.0)
        val stringScore = round(userScore).toString()
        val pointsPossible = intent.getIntExtra("possible",0)
        val answersCorrect = intent.getIntExtra("correct",0)

        possible.setText(pointsPossible)
        correct.setText(answersCorrect)

    }
}