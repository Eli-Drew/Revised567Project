package com.example.elirinker.quizgame

//data class QuizQuestionBank(val questionBank: Question, val language: String, val difficulty: String)

data class Question (val questionResId: Int, val choicesResId: Int, val answer: String, val language: String, val difficulty: String)


