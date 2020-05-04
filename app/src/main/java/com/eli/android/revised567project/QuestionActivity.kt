package com.eli.android.revised567project

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
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
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView
    private lateinit var choicesTextView: TextView


    private val questionViewModel: QuestionViewModel by lazy {
        ViewModelProvider(this).get(QuestionViewModel::class.java)
    }


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
        previousButton = findViewById(R.id.btnPrevious)
        nextButton = findViewById(R.id.btnNext)

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

        nextButton.setOnClickListener {
            questionViewModel.moveToNext()
            updateQuestion()
        }
    }

    //prev is always false because previous button isn't implemented yet.
    private fun updateQuestion() {
        if (questionViewModel.currentIndex >= questionViewModel.questionBank.size) {
            Toast.makeText(this,R.string.out_of_range, LENGTH_SHORT).show()
            getScore()
        }
        else {
            val question = questionViewModel.currentQuestionText
            val choices = questionViewModel.currentChoicesText


            questionTextView.setText(question)
            choicesTextView.setText(choices)
        }

    }

    //helper function for user input
    private fun checkAnswer(userAnswer: String) {

        val correctAnswer = questionViewModel.currentQuestionAnswer
        val messageResID = if (userAnswer == correctAnswer) {
            R.string.correctAnswer
            questionViewModel.correctAnswers++
        }
        else {
            R.string.incorrectAnswer
        }
//        Toast.makeText(this,messageResID,LENGTH_SHORT).show()
    }

    private fun getScore() {
        val score : Double = (questionViewModel.correctAnswers / (questionViewModel.questionBank.size)) * 100
        val possible = questionViewModel.questionBank.size
        val correct = questionViewModel.correctAnswers.toInt()
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("possible", possible)
        intent.putExtra(SCORE, score)
        intent.putExtra("correct", correct)
        startActivity(intent)

    }

}
