package com.eli.android.revised567project

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlin.math.round

private const val CORRECT_MULTIPLIER = 100
private const val  TIME_MULTIPLIER = 10
const val POINTS_CORRECT = "score points correct"
const val POINTS_POSSIBLE = "score points possible"
const val TIME_TAKEN = "time taken"
const val TOTAL_SCORE = "total score."
const val USERNAME = "user's input name"

class ScoreActivity : AppCompatActivity() {

    private lateinit var correctView: TextView
    private lateinit var possibleView: TextView
    private lateinit var timeView: TextView
    private lateinit var pointsView: TextView
    private lateinit var userNameView: View
    private lateinit var saveButton: Button

    private val scoresListViewModel: ScoresListViewModel by lazy {
        ViewModelProvider(this).get(ScoresListViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score_layout)

        correctView = findViewById(R.id.correct_text_view)
        possibleView = findViewById(R.id.possible_text_view)
        pointsView = findViewById(R.id.score_points_text_view)
        timeView = findViewById(R.id.timer_text_view)
        userNameView = findViewById(R.id.score_input_username)
        saveButton = findViewById(R.id.score_save_button)

        val userScore = intent.getDoubleExtra(SCORE,0.0)
        val stringScore = round(userScore).toString()
        val pointsPossible = intent.getIntExtra("possible",0)
        val answersCorrect = intent.getIntExtra("correct",0)
        val timePointsDeducted = intent.getLongExtra("timePoints", 0L)
        val timeElapsed = intent.getStringExtra("time")

        val totalPoints = getTotalPoints(timePointsDeducted,answersCorrect)
//        val totalPoints = CORRECT_MULTIPLIER * answersCorrect

        possibleView.text = pointsPossible.toString()
        correctView.text = answersCorrect.toString()
        pointsView.text = totalPoints.toString()
        timeView.text = timeElapsed


        saveButton.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            val score = UserScore()
            score.time = timeElapsed
            score.totalPoints = totalPoints
            val inputUserName = findViewById<EditText>(R.id.score_input_username)
            val inputUserNameString = inputUserName.text.toString()
            score.userName = inputUserNameString
            scoresListViewModel.saveUserScore(score)
            startActivity(homeIntent)
        }

    } // end of onCreate()

    private fun getTotalPoints(time: Long,  correctAnswers: Int) : Long {
        val seconds = time
        val pointsDeducted = seconds * TIME_MULTIPLIER
        val multiplierPoints = CORRECT_MULTIPLIER * correctAnswers
        return multiplierPoints - pointsDeducted
//        return multiplierPoints - time
    } // end of getTotalPoints()
}