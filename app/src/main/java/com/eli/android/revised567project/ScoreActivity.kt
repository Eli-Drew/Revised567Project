package com.eli.android.revised567project

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.round

private const val CORRECT_MULTIPLIER = 100
private const val  TIME_MULTIPLIER = -10
const val POINTS_CORRECT = "score points correct"
const val POINTS_POSSIBLE = "score points possible"
const val TIME_TAKEN = "time taken"
const val TOTAL_SCORE = "total score."

class ScoreActivity : AppCompatActivity() {

    private lateinit var homeButton: Button
    private lateinit var correctView: TextView
    private lateinit var possibleView: TextView
    private lateinit var timeView: TextView
    private lateinit var pointsView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score_layout)

        correctView = findViewById(R.id.correct_text_view)
        possibleView = findViewById(R.id.possible_text_view)
        pointsView = findViewById(R.id.score_points_text_view)
        timeView = findViewById(R.id.timer_text_view)
        homeButton = findViewById(R.id.score_return_home)

        val userScore = intent.getDoubleExtra(SCORE,0.0)
        val stringScore = round(userScore).toString()
        val pointsPossible = intent.getIntExtra("possible",0)
        val answersCorrect = intent.getIntExtra("correct",0)
        val timeElapsed = intent.getCharSequenceExtra("time")

//        val totalPoints = getTotalPoints(timeElapsed,answersCorrect)
        val totalPoints = CORRECT_MULTIPLIER * answersCorrect

        possibleView.text = pointsPossible.toString()
        correctView.text = answersCorrect.toString()
        pointsView.text = totalPoints.toString()
        timeView.text = timeElapsed

        homeButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            homeIntent.putExtra(POINTS_POSSIBLE, pointsPossible)
            homeIntent.putExtra(POINTS_CORRECT, answersCorrect)
            homeIntent.putExtra(TIME_TAKEN, timeElapsed)
            homeIntent.putExtra(TOTAL_SCORE, totalPoints)
            startActivity(homeIntent)
        }


    }
    fun getTotalPoints(time: CharSequence?,  correctAnswers: Int) : Int {
        val seconds = time.toString().toInt()
        val pointsDeducted = seconds * TIME_MULTIPLIER
        val multiplierPoints = CORRECT_MULTIPLIER * correctAnswers
        return multiplierPoints - pointsDeducted
    }
}