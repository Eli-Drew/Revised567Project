package com.eli.android.revised567project

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.elirinker.quizgame.QuestionViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.difficulty_select.*

private const val TAG = "QuestionActivity"
const val SCORE = "QuestionActivity.score"

class QuestionActivity : AppCompatActivity () {

    private lateinit var abutton: Button
    private lateinit var bbutton: Button
    private lateinit var cbutton: Button
    private lateinit var dbutton: Button
    private lateinit var questionTextView: TextView
    private lateinit var choicesTextView: TextView
    private lateinit var chronometer: Chronometer
    private var running: Boolean = false



    private val questionViewModel: QuestionViewModel by lazy {
        ViewModelProvider(this).get(QuestionViewModel::class.java)
    } // end of val questionViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_activity)

        val language = intent.getStringExtra("language")
        val difficulty = intent.getStringExtra("difficulty")
        val currentQuestionBank = questionViewModel.getQuestionBank(language,difficulty)
        questionViewModel.questionBank = currentQuestionBank

        abutton = findViewById(R.id.a_button)
        bbutton = findViewById(R.id.b_button)
        cbutton = findViewById(R.id.c_button)
        dbutton = findViewById(R.id.d_button)
        chronometer = findViewById(R.id.chronometer_view)

        //linking up the question and choice views to this activity
        questionTextView = findViewById(R.id.question_text_view)
        choicesTextView = findViewById(R.id.choices_view)

        //set first question
        questionTextView.setText(questionViewModel.currentQuestionText)
        choicesTextView.setText(questionViewModel.currentChoicesText)

        //this is setting up the button functionality
        abutton.setOnClickListener {
            checkAnswer("A")
        }
        bbutton.setOnClickListener{
            checkAnswer("B")
        }
        cbutton.setOnClickListener{
            checkAnswer("C")
        }
        dbutton.setOnClickListener{
            checkAnswer("D")
        }

        startChronometer(chronometer)
        chronometer.format = "%S"
    } // nd of override onCreate

    //prev is always false because previous button isn't implemented yet.
    private fun updateQuestion() {
        if (questionViewModel.currentIndex >= questionViewModel.questionBank.size) {
//            Toast.makeText(this,R.string.out_of_range, LENGTH_SHORT).show()
            getScore()
        }
        else {
            val question = questionViewModel.currentQuestionText
            val choices = questionViewModel.currentChoicesText

            questionTextView.setText(question)
            choicesTextView.setText(choices)
        } // end of else

    } // end of fun updateQuestion

    //helper function for user input
    private fun checkAnswer(userAnswer: String) {

        val correctAnswer = questionViewModel.currentQuestionAnswer
        val messageResID = if (userAnswer == correctAnswer) {
            R.string.correctAnswer
            questionViewModel.correctAnswers++
        }
        else {
            R.string.incorrectAnswer
        } // end of else

        questionViewModel.moveToNext()
        updateQuestion()

//        Toast.makeText(this,messageResID,LENGTH_SHORT).show()
    } // end of fun checkAnswer

    private fun getScore() {
        stopChronometer(chronometer)
        var time = chronometer.base
        time %= 100
//        val time = chronometer.contentDescription
        val score : Double = ((questionViewModel.correctAnswers).toDouble() / (questionViewModel.questionBank.size)) * 100
        val possible = questionViewModel.questionBank.size
        val correct = questionViewModel.correctAnswers.toInt()
        val scoreIntent = Intent(this, ScoreActivity::class.java)
        scoreIntent.putExtra("possible", possible)
        scoreIntent.putExtra(SCORE, score)
        scoreIntent.putExtra("correct", correct)
        scoreIntent.putExtra("time", time)
        startActivity(scoreIntent)
    } //  end of fun getScore

    fun startChronometer(view: View) {
        if (!running) {
            chronometer.base
            chronometer.start()
            running = true
        }
    } // end of fun startChrono

    fun stopChronometer(view: View) {
        if (running) {
            chronometer.stop()
        }
    } // end of fun stopChrono

    fun resetChronometer(view: View) {
        if (!running) {
            chronometer.base
        }
    } // end of fun reset chrono

} // end of class QuestionActivity

